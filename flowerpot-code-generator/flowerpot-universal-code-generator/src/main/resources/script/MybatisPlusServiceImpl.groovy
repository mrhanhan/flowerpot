package com.flowerpot.service.system.api

import com.intellij.database.model.DasTable
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

import java.text.SimpleDateFormat
/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */

packageName = "com.mrhan.blog.api;"


FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
  SELECTION.filter { it instanceof DasTable }.each { generate(it, dir) }
}

def generate(table, dir) {
  def tableName = new String(table.getName());
  def name = tableName.replaceAll("^(\\w_)?(.*)\$", "\$2");
  def className = javaName(name, true) + ''
  packageName = getPackageName(dir)
//  new File(dir, className + ".java").withPrintWriter { out ->  }
  def p = new PrintWriter(new OutputStreamWriter(new FileOutputStream( new File(dir, className + "ServiceImpl.java")), "UTF-8"));
  generate(p, className, table.getName())
  p.close();
}


// 获取包所在文件夹路径
def getPackageName(dir) {
  return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}

def generate(out, className, tableName) {
  out.println "package $packageName"
  out.println ""
  out.println "import java.io.Serializable;"
  out.println "import java.util.Date;"
  out.println ""
  out.println "/**"
  out.println " * @author Mrhan"
  out.println " * @date ${new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())}"
  out.println " */"
  out.println "@Service"
  out.println "public class ${className}ServiceImpl extends BaseServiceImpl<${className}, ${className}Mapper> implements ${className}Service {"
  out.println ""
  out.println ""
  out.println "}"
}

def javaName(str, capitalize) {
  def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
          .collect { Case.LOWER.apply(it).capitalize() }
          .join("")
          .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
  capitalize || s.length() == 1? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

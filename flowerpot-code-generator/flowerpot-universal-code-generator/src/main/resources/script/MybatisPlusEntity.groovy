import com.intellij.database.model.DasTable
import com.intellij.database.util.Case
import com.intellij.database.util.DasUtil

import java.text.SimpleDateFormat
import java.util.HashSet
import java.util.Arrays
/*
 * Available context bindings:
 *   SELECTION   Iterable<DasObject>
 *   PROJECT     project
 *   FILES       files helper
 */

packageName = "com.mrhan.blog.api;"

typeMapping = [
  (~/(?i)bigint/)                     : "Long",
  (~/(?i)int|tinyint/)                : "Integer",
  (~/(?i)float|double|decimal|real/)  : "BigDecimal",
  (~/(?i)datetime|timestamp/)         : "Date",
  (~/(?i)date/)                       : "java.sql.Date",
  (~/(?i)time/)                       : "java.sql.Time",
  (~/(?i)/)                           : "String"
]
ignoreFieldSet = new HashSet<String>(Arrays.asList("id", "create_time", "create_by", "modify_time", "modify_by", "effective"))

FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
  SELECTION.filter { it instanceof DasTable }.each { generate(it, dir) }
}

def generate(table, dir) {
  def tableName = new String(table.getName());
  def name = tableName
  def className = javaName(name, true) + ''
  def fields = calcFields(table)
    packageName = getPackageName(dir)
//  new File(dir, className + ".java").withPrintWriter { out ->  }
  def p = new PrintWriter(new OutputStreamWriter(new FileOutputStream( new File(dir, className + ".java")), "UTF-8"));
  generate(p, className, fields, table.getName())
  p.close();
}


// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "") + ";"
}

def generate(out, className, fields, tableName) {
  out.println "package $packageName"
  out.println ""
  out.println "import java.io.Serializable;"
  out.println "import java.util.Date;"
  out.println ""
  out.println "/**"
  out.println " * @author Mrhan"
  out.println " * @date ${new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date())}"
  out.println " */"
  if (tableName != className)
    out.println "@TableName(\"$tableName\")"
    out.println "@Data"
    out.println "@EqualsAndHashCode(callSuper = true)"
  out.println "public class $className extends BaseEntity implements Serializable{"
  out.println ""
  fields.each() {
    if (ignoreFieldSet.contains(it.col)){
      return;
    }
    out.println"    /**"
    out.println"     * ${it.comment == null ? '' : it.comment}"
    out.println"     */"
    if (it.col != it.name)
      out.println "    @TableField(\"${it.col}\")"
    out.println "    private ${it.type} ${it.name};"
  }
  out.println "}"
}

def calcFields(table) {
  DasUtil.getColumns(table).reduce([]) { fields, col ->
    def spec = Case.LOWER.apply(col.getDataType().getSpecification())
    def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value

    fields += [[
                 name : javaName(col.getName(), false),
                 type : typeStr,
                 col : col.getName(),
                 comment: col.getComment() == null ? "" : (new String((col.getComment() as String).getBytes("GBK"))),
                 annos: ""]]
  }
}

def javaName(str, capitalize) {
  def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
    .collect { Case.LOWER.apply(it).capitalize() }
    .join("")
    .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
     capitalize || s.length() == 1? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

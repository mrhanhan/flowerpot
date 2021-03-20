package com.flowerpot.service.system.dao

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

typeMapping = [
        (~/(?i)bigint/)                   : "Long",
        (~/(?i)int|tinyint/)              : "Integer",
        (~/(?i)float|double|decimal|real/): "BigDecimal",
        (~/(?i)datetime|timestamp/)       : "Date",
        (~/(?i)date/)                     : "java.sql.Date",
        (~/(?i)time/)                     : "java.sql.Time",
        (~/(?i)/)                         : "String"
]

FILES.chooseDirectoryAndSave("Choose directory", "Choose where to store generated files") { dir ->
    SELECTION.filter { it instanceof DasTable }.each { generate(it, dir) }
}

def generate(table, dir) {
    def tableName = new String(table.getName());
    def name = tableName.replaceAll("^(\\w_)?(.*)\$", "\$2");
    def className = javaName(name, true) + ''
    def fields = calcFields(table)
    packageName = getPackageName(dir)
//  new File(dir, className + ".java").withPrintWriter { out ->  }
    def p = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(dir, className + "Mapper.xml")), "UTF-8"));
    generate(p, className, fields, table.getName())
    p.close();
}


// 获取包所在文件夹路径
def getPackageName(dir) {
    return dir.toString().replaceAll("\\\\", ".").replaceAll("/", ".").replaceAll("^.*src(\\.main\\.java\\.)?", "")
}

def generate(out, className, fields, tableName) {
    out.println "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n" +
            "<mapper namespace=\"${packageName}.${className}Mapper\">\n";

    def a = 1;
    out.println ''
    out.print "    <sql id = \"common_select_column\">"
    fields.each() {
      out.print "${a == 1 ? ' ' : ', '}${it.col}"
        a = 2;
    }
    out.println "</sql>"

    out.println "</mapper>\n"

}

def calcFields(table) {
    DasUtil.getColumns(table).reduce([]) { fields, col ->
        def spec = Case.LOWER.apply(col.getDataType().getSpecification())
        def typeStr = typeMapping.find { p, t -> p.matcher(spec).find() }.value

        fields += [[
                           name   : javaName(col.getName(), false),
                           type   : typeStr,
                           col    : col.getName(),
                           comment: col.getComment() == null ? "" : (new String((col.getComment() as String).getBytes("GBK"))),
                           annos  : ""]]
    }
}

def javaName(str, capitalize) {
    def s = com.intellij.psi.codeStyle.NameUtil.splitNameIntoWords(str)
            .collect { Case.LOWER.apply(it).capitalize() }
            .join("")
            .replaceAll(/[^\p{javaJavaIdentifierPart}[_]]/, "_")
    capitalize || s.length() == 1 ? s : Case.LOWER.apply(s[0]) + s[1..-1]
}

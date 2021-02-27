package com.flowerapot.generator.universal.mysql;

import com.flowerapot.generator.universal.common.AbstractCodeFile;
import com.flowerapot.generator.universal.common.CodeFile;
import com.flowerapot.generator.universal.common.CodeFileInfo;
import com.flowerapot.generator.universal.common.CommonCodeFileInfo;
import com.flowerapot.generator.universal.common.DataTypeEnum;
import com.flowerapot.generator.universal.mysql.model.TableColumn;
import com.flowerapot.generator.universal.utils.CodeFileUtils;
import com.flowerapot.generator.universal.utils.Console;

import java.io.PrintWriter;
import java.util.Arrays;


public class MysqlTableTest {

    public static void main(String[] args) throws Exception {
        CodeFileInfo info = new CommonCodeFileInfo("a.sql");
        CodeFile file = new AbstractCodeFile(info);

        MysqlTable mysqlTable = new MysqlTable("sys_table", Arrays.asList(
                new TableColumn("id", DataTypeEnum.LONG, null, null, true, "ID")
                ,new TableColumn("name", DataTypeEnum.VARCHAR, "32", null, true, "名称")
        ));
        mysqlTable.generator(file);
        mysqlTable.generator(file);
        Console.print(file.getInputStream());

        CodeFileUtils.writeToFile(file, MysqlTableTest.class.getResource("").getFile());
    }
}
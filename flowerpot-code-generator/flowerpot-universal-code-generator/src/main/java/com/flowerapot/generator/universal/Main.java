package com.flowerapot.generator.universal;

import com.flowerapot.generator.universal.common.AbstractCodeFile;
import com.flowerapot.generator.universal.common.CodeFile;
import com.flowerapot.generator.universal.common.CodeFileInfo;
import com.flowerapot.generator.universal.common.CommonCodeFileInfo;
import com.flowerapot.generator.universal.common.DataTypeEnum;
import com.flowerapot.generator.universal.mysql.MysqlTable;
import com.flowerapot.generator.universal.mysql.model.TableColumn;
import com.flowerapot.generator.universal.utils.Console;

import java.util.Arrays;

/**
 * Main
 *
 * @author Mrhan
 * @date 2021/2/27 10:36
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Main");
        CodeFileInfo info = new CommonCodeFileInfo("a.sql");
        CodeFile file = new AbstractCodeFile(info);

        MysqlTable mysqlTable = new MysqlTable("sys_table", Arrays.asList(
                new TableColumn("id", DataTypeEnum.LONG, null, null, true, "ID")
                ,new TableColumn("name", DataTypeEnum.VARCHAR, "32", null, true, "名称")
        ));
        mysqlTable.generator(file);
        Console.print(file.getInputStream());
    }
}

package com.flowerapot.generator.universal.mysql;

import com.flowerapot.generator.universal.common.CodeFile;
import com.flowerapot.generator.universal.common.Generator;
import com.flowerapot.generator.universal.mysql.model.TableColumn;
import lombok.Data;

import java.util.List;

/**
 * Mysql
 *
 * @author Mrhan
 * @date 2021/2/26 0:21
 */
@Data
public class MysqlTable implements Generator {

    /**
     * 表名称
     */
    private String tableName;
    /**
     * Column
     */
    private List<TableColumn> columns;

    @Override
    public void generator(CodeFile file) {
        file.newLine(1);
        file.write("DROP TABLE IF EXISTS %s;", tableName).newLine(1);
        file.write("CREATE TABLE %s (", tableName).newLine(1);
        for (TableColumn tableColumn : columns) {
            file.writeTab(1).write("%s %s %s COMMENT '%s'").newLine(1);
        }
        file.write(");");

    }
}

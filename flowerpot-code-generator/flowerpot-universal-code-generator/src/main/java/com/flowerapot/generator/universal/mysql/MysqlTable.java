package com.flowerapot.generator.universal.mysql;

import com.flowerapot.generator.universal.common.CodeFile;
import com.flowerapot.generator.universal.common.Generator;
import com.flowerapot.generator.universal.mysql.model.TableColumn;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Mysql
 *
 * @author Mrhan
 * @date 2021/2/26 0:21
 */
@Data
@Accessors
public class MysqlTable implements Generator {

    /**
     * 表名称
     */
    private String tableName;
    /**
     * Column
     */
    private List<TableColumn> columns;

    public MysqlTable(String tableName, List<TableColumn> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    @Override
    public void generator(CodeFile file) {
        file.newLine(1);
        file.write("DROP TABLE IF EXISTS %s;", tableName).newLine(1);
        file.write("CREATE TABLE %s (", tableName).newLine(1);
        for (int i = 0; i < columns.size(); i++) {
            TableColumn tableColumn = columns.get(i);
            file.writeTab(1).write("%s %s %s COMMENT '%s'", tableColumn.getName()
                    , getColumnType(tableColumn)
                    , getColumnAttribute(tableColumn)
                    , tableColumn.getComment());
            if (i < columns.size() - 1) {
                file.write(",");
            }
            file.newLine(1);
        }
        file.write(");");
    }

    /**
     * 获取列属性
     * @param tableColumn   表Column
     * @return      返回属性字符串
     */
    private Object getColumnAttribute(TableColumn tableColumn) {
        StringBuilder builder = new StringBuilder();
        if (tableColumn.isCanNotNull()) {
            builder.append(" NOT NULL ");
        }
        if (StringUtils.isNotBlank(tableColumn.getDefaultValue())) {
            builder.append(" DEFAULT '" ).append(tableColumn.getDefaultValue()).append("' ");
        }
        return builder.toString();
    }

    /**
     * @param tableColumn   列信息
     * @return              返回此列对应的数据类型
     */
    private String getColumnType(TableColumn tableColumn) {
        return tableColumn.getType().getSqlType() + (StringUtils.isBlank(tableColumn.getLength()) ? "" : ("(" + tableColumn.getLength() + ")"));
    }
}

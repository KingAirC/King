package com.king.generator.service;

import com.king.generator.pojo.MysqlTable;

import java.util.List;

public interface GeneratorServiceI {
    void generate(String tableName);

    List<MysqlTable> read4MysqlTable(MysqlTable mysqlTable);

    int select4TableCount(MysqlTable mysqlTable);
}

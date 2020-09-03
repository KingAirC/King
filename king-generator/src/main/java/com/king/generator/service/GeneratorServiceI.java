package com.king.generator.service;

import com.king.generator.pojo.GenTable;

import java.util.List;

public interface GeneratorServiceI {

    List<GenTable> read4GenTable(GenTable genTable);

    byte[] generatorCode(String tableName);

    int select4TableCount(GenTable genTable);
}

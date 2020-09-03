package com.king.generator.mapper;

import com.king.generator.pojo.GenTable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenTableMapper {

    List<GenTable> select4GenTable(GenTable genTable);

    GenTable select4DetailByTableName(String tableName);

    int select4Count(GenTable genTable);
}

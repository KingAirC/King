package com.king.generator.mapper;

import com.king.generator.pojo.MysqlTable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysqlTableMapper {

    List<MysqlTable> select4MysqlTable(MysqlTable mysqlTable);

    int select4Count(MysqlTable mysqlTable);
}

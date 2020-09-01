package com.king.generator.mapper;

import com.king.generator.pojo.MysqlField;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysqlFieldMapper {
    List<MysqlField> selectMysqlFieldsByTableName(String tableName);
}

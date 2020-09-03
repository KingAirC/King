package com.king.generator.mapper;

import com.king.generator.pojo.GenTableColumn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenTableColumnMapper {
    List<GenTableColumn> selectTableColumnsByTableName(String tableName);
}

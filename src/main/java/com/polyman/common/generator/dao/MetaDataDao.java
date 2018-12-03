package com.polyman.common.generator.dao;

import java.util.List;
import java.util.Map;

import com.polyman.common.generator.model.MetaColumn;
import com.polyman.common.generator.model.MetaTable;

public interface MetaDataDao {

    List<MetaTable> queryTable(Map<String,Object> paras);
	
    List<MetaColumn> queryColumn(Map<String,Object> paras);
}

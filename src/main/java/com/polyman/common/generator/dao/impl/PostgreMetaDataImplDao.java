package com.polyman.common.generator.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.polyman.common.generator.dao.MetaDataDao;
import com.polyman.common.generator.model.MetaColumn;
import com.polyman.common.generator.model.MetaTable;

@Repository("postgreMetaDataImplDao")
public class PostgreMetaDataImplDao implements MetaDataDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;  
	
	@Override
	public List<MetaTable> queryTable(Map<String, Object> paras) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MetaColumn> queryColumn(Map<String, Object> paras) {
		// TODO Auto-generated method stub
		return null;
	}

}

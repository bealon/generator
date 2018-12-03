package com.polyman.common.generator.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.polyman.common.generator.dao.MetaDataDao;
import com.polyman.common.generator.model.MetaColumn;
import com.polyman.common.generator.model.MetaTable;

@Repository("mySqlMetaDataImplDao")
public class MySqlMetaDataImplDao implements MetaDataDao {

	private static final String insertTableSql= "select table_name tableName, table_comment tableComment "
			+ " from information_schema.tables where  table_schema = ? ";
	
	private static final String insertColumnSql="select column_name columnName , data_type dataType , column_comment columnComment ,"
			+ "case when column_key='PRI' then 1 else 0 end columnKey ,case when extra='auto_increment' then 1 else 0 end autoIncrement ,case when is_nullable='NO' then 1 else 0 end isNull ,"
			+ "CHARACTER_MAXIMUM_LENGTH stringLength ,NUMERIC_PRECISION numberPre,NUMERIC_SCALE numberScale  "
			+ "from information_schema.columns where table_name =? and table_schema  =? ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;  
	 
	@Override
	public List<MetaTable> queryTable(Map<String, Object> paras) {	
		RowMapper<MetaTable> rowMapper = new BeanPropertyRowMapper<>(MetaTable.class);
		List<MetaTable> ls=jdbcTemplate.query(insertTableSql, rowMapper,paras.get("tableSchema"));
		return ls;
	}

	@Override
	public List<MetaColumn> queryColumn(Map<String, Object> paras) {
		
		RowMapper<MetaColumn> rowMapper = new BeanPropertyRowMapper<>(MetaColumn.class);
		List<MetaColumn> ls=jdbcTemplate.query(insertColumnSql, rowMapper,new Object[]{paras.get("tableName"),paras.get("tableSchema")});
		return ls;
	}

}

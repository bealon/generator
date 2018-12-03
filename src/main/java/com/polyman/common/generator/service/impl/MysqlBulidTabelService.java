package com.polyman.common.generator.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.polyman.common.generator.dao.MetaDataDao;
import com.polyman.common.generator.model.MetaColumn;
import com.polyman.common.generator.model.MetaTable;

@Service("mysqlBulidTabelService")
public class MysqlBulidTabelService extends AbstractBulidTabelService{

	@Autowired
	@Qualifier("mySqlMetaDataImplDao")
	MetaDataDao mySqlMetaDataImplDao;
	
	@Override
	public List<MetaTable> getTableList() {
		Map<String,Object> paras=new HashMap<>();
		paras.put("tableSchema", configTabelPolicyBean.getTableSchema());
		return mySqlMetaDataImplDao.queryTable(paras);
	}

	@Override
	public List<MetaColumn> getColumnList(String tableName) {
		Map<String,Object> paras=new HashMap<>();
		paras.put("tableSchema", configTabelPolicyBean.getTableSchema());
		paras.put("tableName", tableName);
		
		return mySqlMetaDataImplDao.queryColumn(paras);
	}

}

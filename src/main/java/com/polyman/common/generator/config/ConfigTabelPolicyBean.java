package com.polyman.common.generator.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.polyman.common.generator.utils.NamingStrategy;

@Component
@ConfigurationProperties(prefix="generator.tabelPolicy")
public class ConfigTabelPolicyBean {
  
	private String  tableSchema;
	/**
	 * 是否有模块，看表的命名规则。如果是下划线方式，取第一个下划线之前字符串。如果是驼峰方式，取第一个大写字母之前的字符串。
	 * 否则没有模块
	 */
	private boolean hasMoudule;
	
	private NamingStrategy tableNamingStrategy=NamingStrategy.underline_to_camel;
	
	private NamingStrategy colNamingStrategy=NamingStrategy.underline_to_camel;
	
	private List<String> allowedTables = new ArrayList<String>();
	
	private List<String> refuseTables = new ArrayList<String>();
	
	public String getTableSchema() {
		return tableSchema;
	}


	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}


	public boolean isHasMoudule() {
		return hasMoudule;
	}


	public void setHasMoudule(boolean hasMoudule) {
		this.hasMoudule = hasMoudule;
	}


	public NamingStrategy getTableNamingStrategy() {
		return tableNamingStrategy;
	}


	public void setTableNamingStrategy(NamingStrategy tableNamingStrategy) {
		this.tableNamingStrategy = tableNamingStrategy;
	}


	public List<String> getAllowedTables() {
		return allowedTables;
	}


	public void setAllowedTables(List<String> allowedTables) {
		this.allowedTables = allowedTables;
	}


	public List<String> getRefuseTables() {
		return refuseTables;
	}


	public void setRefuseTables(List<String> refuseTables) {
		this.refuseTables = refuseTables;
	}


	public NamingStrategy getColNamingStrategy() {
		return colNamingStrategy;
	}


	public void setColNamingStrategy(NamingStrategy colNamingStrategy) {
		this.colNamingStrategy = colNamingStrategy;
	}
	

}

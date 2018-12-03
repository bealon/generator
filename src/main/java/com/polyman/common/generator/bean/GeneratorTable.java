package com.polyman.common.generator.bean;

import java.util.List;

public class GeneratorTable {

	private String  tableSchema;
	
	private String  tableName;
	
	private String  tableComment;
	
	private String  beanName;
	/**
	 *如果有分模块，获取表下划线开头的字符串，
	 *如果没有下划线，获取表名称大写字母之前的字符串
	 */
	private String  moduleName;
	
	List<GeneratorColumnBean> columns;
	
	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getModuleName() {
		return moduleName == null ? "" : moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public List<GeneratorColumnBean> getColumns() {
		return columns;
	}

	public void setColumns(List<GeneratorColumnBean> columns) {
		this.columns = columns;
	}

}

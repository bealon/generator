package com.polyman.common.generator.bean;

/**
 * 因为无法获取多个display queryModel的值
 * 默认从注释获取。第一行为注释的值，第二行为queryModel的值，第三行为是否生产多个显示层bean的值
 * @author bealon
 *
 */
public class GeneratorColumnBean {

	private String  columnKey;
	private String  autoIncrement;
	private String  columnName;
	private String  propertyName;
	private String  columnComment;
	private String  isNull;
	private String  dataType;
	private String  length;
	private String  numberPre;
	private String  numberScale;
	/**
	 * 把新增  修改  查询 显示结果的对象 与低层model对象分开。默认和model对象一致。见 FiledDisplay
	 */
	private Integer display;
	/**
	 * 用来生产查询字段的通配符。见 QueryModeType  多个用，分割。
	 */
	private String  queryModel;


	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	public String getIsNull() {
		return isNull;
	}
	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getNumberPre() {
		return numberPre;
	}
	public void setNumberPre(String numberPre) {
		this.numberPre = numberPre;
	}
	public String getNumberScale() {
		return numberScale;
	}
	public void setNumberScale(String numberScale) {
		this.numberScale = numberScale;
	}

	public Integer getDisplay() {
		return display;
	}
	public void setDisplay(Integer display) {
		this.display = display;
	}

	public String getAutoIncrement() {
		return autoIncrement;
	}
	public void setAutoIncrement(String autoIncrement) {
		this.autoIncrement = autoIncrement;
	}
	public String getQueryModel() {
		return queryModel;
	}
	public void setQueryModel(String queryModel) {
		this.queryModel = queryModel;
	}
	
}

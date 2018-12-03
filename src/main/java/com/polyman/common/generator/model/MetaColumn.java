package com.polyman.common.generator.model;

import com.polyman.common.generator.utils.NamingStrategy;

public class MetaColumn {

	private String columnKey;
	private String autoIncrement;
	private String columnName;
	private String columnComment;
	private String isNull;
	private String dataType;
	private String stringLength;
	private String numberPre;
	private String numberScale;

	public String getColumnKey() {
		if(NamingStrategy.isEmpty(columnKey)){
			return null;
		}
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	public String getColumnName() {
		if(NamingStrategy.isEmpty(columnName)){
			return null;
		}
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnComment() {
		if(NamingStrategy.isEmpty(columnComment)){
			return "";
		}
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getIsNull() {
		if(NamingStrategy.isEmpty(isNull)){
			return "0";
		}
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

	public String getStringLength() {
		if(NamingStrategy.isEmpty(stringLength)){
			return null;
		}
		return stringLength;
	}

	public void setStringLength(String stringLength) {
		this.stringLength = stringLength;
	}

	public String getNumberPre() {
		if(NamingStrategy.isEmpty(numberPre)){
			return null;
		}
		return numberPre;
	}

	public void setNumberPre(String numberPre) {
		this.numberPre = numberPre;
	}

	public String getNumberScale() {
		if(NamingStrategy.isEmpty(numberScale)){
			return null;
		}
		return numberScale;
	}

	public void setNumberScale(String numberScale) {
		this.numberScale = numberScale;
	}

	public String getAutoIncrement() {
		if(NamingStrategy.isEmpty(autoIncrement)){
			return "0";
		}
		return autoIncrement;
	}

	public void setAutoIncrement(String autoIncrement) {
		this.autoIncrement = autoIncrement;
	}

}

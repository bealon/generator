package com.polyman.common.generator.enums;

public enum QueryModeType {

	EQUAL("0","="),
	NOEQUAL("1","!="),
	LESS("2","&lt;"),
	GREATER("3","$gt;"),
	LESS_EQUAL("4","&lt;="),
	GREATER_EQUAL("5","$gt;="),
	MATCH_ALL("6",null),
	MATCH_LEFT("7",null),
	BETWEEN ("8",null),
	IN ("9",null)
	;

	private String type;
	
	private String des;

	private QueryModeType(String type, String des) {
		this.type = type;
		this.des = des;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	public static String getOp(String queryModel){
		for(QueryModeType queryModeType:QueryModeType.values()){
			if(queryModel.indexOf(queryModeType.getType()) != -1 ){
				return queryModeType.getDes();
			}
		}
		return QueryModeType.EQUAL.getDes();
	}
	
}

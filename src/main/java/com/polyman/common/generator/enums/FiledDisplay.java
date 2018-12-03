package com.polyman.common.generator.enums;

public enum FiledDisplay {
   
	ADD(1,"新增"),
	UPDATE(2,"修改"),
	QUERY(4,"查询"),
	VIEW(8,"显示");
	
    private int type;
	
	private String des;
	
	private FiledDisplay(int type, String des) {
		this.type = type;
		this.des = des;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	public static boolean isAdd(int number){
		return  (number & FiledDisplay.ADD.getType()) == FiledDisplay.ADD.getType();
	}
	
	public static boolean isUpdate(int number){
		return  (number & FiledDisplay.UPDATE.getType()) == FiledDisplay.UPDATE.getType();
	}
	
	public static boolean isQuery(int number){
		return  (number & FiledDisplay.QUERY.getType()) == FiledDisplay.QUERY.getType();
	}
	
	public static boolean isView(int number){
		return  (number & FiledDisplay.VIEW.getType()) == FiledDisplay.VIEW.getType();
	}
}

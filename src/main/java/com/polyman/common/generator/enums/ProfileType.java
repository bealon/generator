package com.polyman.common.generator.enums;

public enum ProfileType {
    /**
     * 单项目 
     */
	SINGLE("single"),
	/**
	 * 多项目
	 */
	MULTI("multi");
	
	
	private final String value;
	
	ProfileType(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}
}

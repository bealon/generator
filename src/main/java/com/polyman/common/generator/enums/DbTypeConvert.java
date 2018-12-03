package com.polyman.common.generator.enums;

public enum DbTypeConvert {

	MYSQL(DbType.MYSQL, "mySqlTypeConvert"),
	ORACLE(DbType.ORACLE, "oracleTypeConvert"), 
	SQL_SERVER(DbType.SQL_SERVER,"sqlServerTypeConvert"),
	POSTGRE_SQL(DbType.POSTGRE_SQL, "postgreSqlTypeConvert"); 


	private DbType dbType;

	private String dbTypeConvertName;

	private DbTypeConvert(DbType dbType, String dbTypeConvertName) {
		this.dbType = dbType;
		this.dbTypeConvertName = dbTypeConvertName;
	}

	
	public static String getDbtypeConvertName( DbType dbType) {
		DbTypeConvert [] dbTypeConverts=DbTypeConvert.values();
		for(int i=0;i<dbTypeConverts.length;i++){
			if(dbTypeConverts[i].getDbType().equals(dbType)){
				return dbTypeConverts[i].getDbTypeConvertName();
			}	
		}
		return null;
	}


	public DbType getDbType() {
		return dbType;
	}


	public void setDbType(DbType dbType) {
		this.dbType = dbType;
	}


	public String getDbTypeConvertName() {
		return dbTypeConvertName;
	}


	public void setDbTypeConvertName(String dbTypeConvertName) {
		this.dbTypeConvertName = dbTypeConvertName;
	}
	
	
}

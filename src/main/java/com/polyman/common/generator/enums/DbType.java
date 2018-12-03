/**
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.polyman.common.generator.enums;

/**
 * 数据库类型定义
 *
 */
public enum DbType {
	
    MYSQL("mysql"),
    ORACLE("oracle"),
    SQL_SERVER("sql_server"),
    POSTGRE_SQL("postgre_sql"),
    OTHER("other db");


    private final String value;


    DbType(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
    
    public static DbType getDbTypeByValue(String value){
    	for (DbType e : DbType.values()) {  
    	    if(e.getValue().equals(value)) {
    	    	return e;
    	    }
    	} 
    	return null;
    }

}
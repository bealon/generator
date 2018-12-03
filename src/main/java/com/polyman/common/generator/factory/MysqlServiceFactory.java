package com.polyman.common.generator.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.polyman.common.generator.service.GeneratorService;

public class MysqlServiceFactory implements ServiceFacory {
	
	
	@Autowired
	@Qualifier("mysqlBulidTabelService")
	GeneratorService mysqlBulidTabelService;

	@Override
	public GeneratorService create() {
		return mysqlBulidTabelService;
	}

}

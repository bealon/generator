package com.polyman.common.generator.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.polyman.common.generator.factory.MysqlServiceFactory;
import com.polyman.common.generator.factory.ServiceFacory;

@Configuration
public class ProfileConfig {

	@Bean("serviceFactory")
	@ConditionalOnExpression("'${generator.config.db-type}'.equals('mysql')")
	public ServiceFacory getMysqlServiceFactory(){
		return new MysqlServiceFactory();
	}
}

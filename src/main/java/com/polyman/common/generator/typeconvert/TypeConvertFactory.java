package com.polyman.common.generator.typeconvert;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

import com.polyman.common.generator.enums.DbType;
import com.polyman.common.generator.enums.DbTypeConvert;

@Service
public class TypeConvertFactory implements BeanFactoryAware{

	private BeanFactory beanFactory; 
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory=beanFactory;
	}
	
	public  TypeConvert getTypeConvert(DbType dbType){
		return (TypeConvert) beanFactory.getBean(DbTypeConvert.getDbtypeConvertName(dbType));
	}
}

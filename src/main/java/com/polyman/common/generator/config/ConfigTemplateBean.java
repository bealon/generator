package com.polyman.common.generator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;



@Component
@ConfigurationProperties(prefix="generator.template")
public class ConfigTemplateBean {

	private boolean addRequestTemplate=true;
	
	private boolean updateRequestTemplate=true;
	
	private boolean queryRequestTemplate=true;
	
	private boolean viewTemplate=true;
	
	private boolean daoTemplate=true;
	
	private boolean modelTemplate=true;

	private boolean xmlTemplate=true;
	
	private boolean serviceTemplate=true;
	
	private boolean serviceImplTemplate=true;
	
	private boolean controllerTemplate=true;
	
	private boolean mainTemplate=true;

	public boolean isAddRequestTemplate() {
		return addRequestTemplate;
	}

	public void setAddRequestTemplate(boolean addRequestTemplate) {
		this.addRequestTemplate = addRequestTemplate;
	}

	public boolean isUpdateRequestTemplate() {
		return updateRequestTemplate;
	}

	public void setUpdateRequestTemplate(boolean updateRequestTemplate) {
		this.updateRequestTemplate = updateRequestTemplate;
	}

	public boolean isViewTemplate() {
		return viewTemplate;
	}

	public void setViewTemplate(boolean viewTemplate) {
		this.viewTemplate = viewTemplate;
	}

	public boolean isDaoTemplate() {
		return daoTemplate;
	}

	public void setDaoTemplate(boolean daoTemplate) {
		this.daoTemplate = daoTemplate;
	}

	public boolean isModelTemplate() {
		return modelTemplate;
	}

	public void setModelTemplate(boolean modelTemplate) {
		this.modelTemplate = modelTemplate;
	}

	public boolean isQueryRequestTemplate() {
		return queryRequestTemplate;
	}

	public void setQueryRequestTemplate(boolean queryRequestTemplate) {
		this.queryRequestTemplate = queryRequestTemplate;
	}

	public boolean isServiceTemplate() {
		return serviceTemplate;
	}

	public void setServiceTemplate(boolean serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}

	public boolean isServiceImplTemplate() {
		return serviceImplTemplate;
	}

	public void setServiceImplTemplate(boolean serviceImplTemplate) {
		this.serviceImplTemplate = serviceImplTemplate;
	}

	public boolean isXmlTemplate() {
		return xmlTemplate;
	}

	public void setXmlTemplate(boolean xmlTemplate) {
		this.xmlTemplate = xmlTemplate;
	}

	public boolean isControllerTemplate() {
		return controllerTemplate;
	}

	public void setControllerTemplate(boolean controllerTemplate) {
		this.controllerTemplate = controllerTemplate;
	}

	public boolean isMainTemplate() {
		return mainTemplate;
	}

	public void setMainTemplate(boolean mainTemplate) {
		this.mainTemplate = mainTemplate;
	}

}

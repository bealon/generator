package com.polyman.common.generator.template;

public interface TemplateVm {
	
	 boolean isBulid();

	 String getFileName(String packagePath,String module,String beanName);
	
	 String getProjectName();
	 
	 String getPathName();
}

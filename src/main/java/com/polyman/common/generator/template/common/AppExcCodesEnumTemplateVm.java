package com.polyman.common.generator.template.common;


import java.io.File;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class AppExcCodesEnumTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "common" + File.separator +"enums" + File.separator+ "AppExcCodesEnum.java";
	}

	@Override
	public String getPathName() {
		return "template/common/AppExcCodesEnum.java.vm";
	}

	
	@Override
	public String getProjectName() {
		return configBean.getApiModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		return true;
	}  

}

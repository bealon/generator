package com.polyman.common.generator.template.common;


import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.polyman.common.generator.config.ConfigBean;
import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class ExceptionHandlerAdviceTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "web" + File.separator + "interceptor"+ File.separator+"ExceptionHandlerAdvice.java";
	}

	@Override
	public String getPathName() {
		return "template/common/ExceptionHandlerAdvice.java.vm";
	}

	
	@Override
	public String getProjectName() {
		return configBean.getWebModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		return true;
	}  

}

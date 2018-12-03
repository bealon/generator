package com.polyman.common.generator.template.common;

import java.io.File;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class LoginRequestTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "bean" + File.separator + "LoginRequest.java";
	}

	@Override
	public String getPathName() {
		return "template/common/LoginRequest.java.vm";
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

package com.polyman.common.generator.template.shiro;


import java.io.File;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class UserNamePassWordRealmTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "common" + File.separator +"shiro"+ File.separator+ "UserNamePassWordRealm.java";
	}

	@Override
	public String getPathName() {
		return "template/shiro/UserNamePassWordRealm.java.vm";
	}

	
	@Override
	public String getProjectName() {
		return configBean.getApiModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		return configBean.getShiroFlag();
	}  

}

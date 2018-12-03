package com.polyman.common.generator.template;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class ManagerControllerTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "web" + File.separator+"controller"+ File.separator+"ManagerController.java";
	}

	@Override
	public String getPathName() {
		return "template/ManagerController.java.vm";
	}

	@Override
	public String getProjectName() {
		return configBean.getWebModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		// TODO Auto-generated method stub
		return configBean.getShiroFlag();
	}

}

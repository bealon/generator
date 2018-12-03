package com.polyman.common.generator.template;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class ServiceImplTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "service" + File.separator+module+"impl"+ File.separator+ beanName + "ServiceImpl.java";
	}

	@Override
	public String getPathName() {
		return "template/ServiceImpl.java.vm";
	}

	@Override
	public String getProjectName() {
		
		return configBean.getSrvModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		// TODO Auto-generated method stub
		return configTemplateBean.isServiceImplTemplate();
	}

}

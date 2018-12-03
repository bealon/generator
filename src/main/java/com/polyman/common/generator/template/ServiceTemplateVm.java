package com.polyman.common.generator.template;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class ServiceTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "service" + File.separator+module+ beanName + "Service.java";
	}

	@Override
	public String getPathName() {
		return "template/Service.java.vm";
	}

	@Override
	public String getProjectName() {
		// TODO Auto-generated method stub
		return configBean.getApiModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		// TODO Auto-generated method stub
		return configTemplateBean.isServiceTemplate();
	}

}

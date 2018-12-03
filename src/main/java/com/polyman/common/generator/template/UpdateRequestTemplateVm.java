package com.polyman.common.generator.template;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class UpdateRequestTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "bean" + File.separator +module+ "Update"+beanName + "Request.java";
	}

	@Override
	public String getPathName() {
		return "template/UpdateBean.java.vm";
	}

	@Override
	public String getProjectName() {
		// TODO Auto-generated method stub
		return configBean.getApiModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		// TODO Auto-generated method stub
		return configTemplateBean.isUpdateRequestTemplate();
	}

}

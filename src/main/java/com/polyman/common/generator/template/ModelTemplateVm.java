package com.polyman.common.generator.template;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class ModelTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "model" + File.separator +module+ beanName + ".java";
	}

	@Override
	public String getPathName() {
		return "template/Model.java.vm";
	}


	@Override
	public String getProjectName() {
		// TODO Auto-generated method stub
		return configBean.getSrvModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		// TODO Auto-generated method stub
		return configTemplateBean.isModelTemplate();
	}

}

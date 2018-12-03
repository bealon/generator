package com.polyman.common.generator.template;

import java.io.File;

import org.springframework.stereotype.Service;

@Service
public class ViewTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "view" + File.separator +module+ beanName + "Bean.java";
	}

	@Override
	public String getPathName() {
		return "template/View.java.vm";
	}

	@Override
	public String getProjectName() {
		// TODO Auto-generated method stub
		return configBean.getApiModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		// TODO Auto-generated method stub
		return configTemplateBean.isViewTemplate();
	}

}

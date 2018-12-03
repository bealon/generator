package com.polyman.common.generator.template;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.utils.NamingStrategy;

@Service
public class MainTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + NamingStrategy.capitalFirst(configBean.getProjectName())+"WebApplication.java";
	}

	@Override
	public String getPathName() {
		return "template/Main.java.vm";
	}

	@Override
	public String getProjectName() {
		return configBean.getWebModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		return configTemplateBean.isMainTemplate();
	}

}

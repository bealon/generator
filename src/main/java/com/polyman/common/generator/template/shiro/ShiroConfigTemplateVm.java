package com.polyman.common.generator.template.shiro;


import java.io.File;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class ShiroConfigTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return packagePath + "config" + File.separator + "ShiroConfig.java";
	}

	@Override
	public String getPathName() {
		return "template/shiro/ShiroConfig.java.vm";
	}

	
	@Override
	public String getProjectName() {
		return configBean.getWebModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		return configBean.getShiroFlag();
	}  

}

package com.polyman.common.generator.template.common;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.constants.ConstVal;
import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class LogbackTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return ConstVal.RESOURCES_PATH +"logback-spring.xml";
	}

	@Override
	public String getPathName() {
		return "template/common/logback.xml.vm";
	}

	@Override
	public String getProjectName() {
		return configBean.getWebModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		return true;
	}

}

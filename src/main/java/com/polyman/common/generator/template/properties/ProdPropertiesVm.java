package com.polyman.common.generator.template.properties;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.constants.ConstVal;
import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class ProdPropertiesVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return ConstVal.RESOURCES_PATH +"application-prod.properties";
	}

	@Override
	public String getPathName() {
		return "template/properties/application-prod.properties.vm";
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

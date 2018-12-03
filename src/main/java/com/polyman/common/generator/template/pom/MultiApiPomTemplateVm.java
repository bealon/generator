package com.polyman.common.generator.template.pom;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.constants.ConstVal;
import com.polyman.common.generator.template.AbstractTemplateVm;

@Service
public class MultiApiPomTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module,String beanName) {
		return "pom.xml";
	}

	@Override
	public String getPathName() {
		return "template/pom/multiApiPom.xml.vm";
	}

	@Override
	public String getProjectName() {
		return configBean.getApiModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		String activeProfile=getActiveProfile();
		return activeProfile.equals(ConstVal.PROFILE_MULTI);
	}

}

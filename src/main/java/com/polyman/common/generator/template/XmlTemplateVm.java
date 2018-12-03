package com.polyman.common.generator.template;

import java.io.File;

import org.springframework.stereotype.Service;

import com.polyman.common.generator.constants.ConstVal;

@Service
public class XmlTemplateVm extends AbstractTemplateVm {

	@Override
	public String getFileName(String packagePath,String module, String beanName) {
		
		return ConstVal.RESOURCES_PATH + "mybatis"+ File.separator +module+beanName + "Dao.xml";
	}

	@Override
	public String getPathName() {
		return "template/Dao.xml.vm";
	}

	@Override
	public String getProjectName() {
		return configBean.getSrvModuleName();
	}

	@Override
	public boolean getBulidFlag() {
		// TODO Auto-generated method stub
		return configTemplateBean.isXmlTemplate();
	}

}

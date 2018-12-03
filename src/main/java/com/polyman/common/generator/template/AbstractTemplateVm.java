package com.polyman.common.generator.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.polyman.common.generator.config.ConfigBean;
import com.polyman.common.generator.config.ConfigTemplateBean;

@Service
public abstract class AbstractTemplateVm implements TemplateVm, ApplicationContextAware {

	protected ApplicationContext applicationContext;

	@Autowired
	protected ConfigTemplateBean configTemplateBean;
	
	@Autowired
	protected ConfigBean configBean;
	
	public void setApplicationContext(ApplicationContext applicationContext)   {
		this.applicationContext = applicationContext;
	}

	public  ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}

	public  String getActiveProfile() {
        return applicationContext.getEnvironment().getActiveProfiles()[0];
    }
	
	@Override
	public boolean isBulid() {
		return getBulidFlag();
	}

	public abstract boolean getBulidFlag();
}

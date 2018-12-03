package com.polyman.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.polyman.common.generator.factory.ServiceFacory;

@SpringBootApplication
public class PolymanGeneratorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cx = SpringApplication.run(PolymanGeneratorApplication.class, args);
		ServiceFacory s = (ServiceFacory) cx.getBean("serviceFactory");
		s.create().bulidCode();
		System.out.println("===============================bulid end======================");
	}
}

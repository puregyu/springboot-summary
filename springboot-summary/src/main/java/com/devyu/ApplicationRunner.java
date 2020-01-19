package com.devyu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.devyu.properties.PropertiesBean;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{

	
	@Autowired
	private PropertiesBean propertiesBean;
	
	@Value("${devyu.name}")
	private String name;
	
	@Value("${devyu.age}")
	private int age;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// true
		System.out.println("program args : "+args.containsOption("program"));
		// false
		System.out.println("vm args : "+args.containsOption("vm"));
		
		System.out.println(name);
		System.out.println(age);
		
		System.err.println(propertiesBean.getName());
		System.err.println(propertiesBean.getAge());
	}

}

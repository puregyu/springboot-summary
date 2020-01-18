package com.devyu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// true
		System.out.println("프로그램 아규먼트 : "+args.containsOption("program"));
		// false
		System.out.println("vm 아규먼트 : "+args.containsOption("vm"));
		
	}

}

package com.devyu.arguments;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class Args {
	public Args(ApplicationArguments applicationArguments) {
		
		// true
		//System.out.println("프로그램 아규먼트 : "+applicationArguments.containsOption("program"));
		// false
		//System.out.println("vm 아규먼트 : "+applicationArguments.containsOption("vm"));
		// jvm 옵션은 어플리케이션 아규먼트가 아니다
	
	}
}

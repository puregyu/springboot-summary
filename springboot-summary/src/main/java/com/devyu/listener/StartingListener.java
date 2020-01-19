package com.devyu.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component // SpringApplication 생성할 때 직적 객체를 만들기 때문에 빈 등록 할 필요 없음
public class StartingListener implements ApplicationListener<ApplicationStartingEvent>{
	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("================");
		System.out.println("Application Started Event");
		System.out.println("================");
	}
}

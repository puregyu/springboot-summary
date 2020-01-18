package com.devyu;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 웹 서버 port 확인하기

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent>{

	@Override
	public void onApplicationEvent(ServletWebServerInitializedEvent event) {
		ServletWebServerApplicationContext applicationContext = event.getApplicationContext();
		System.out.println(applicationContext.getWebServer().getPort());
	}

}

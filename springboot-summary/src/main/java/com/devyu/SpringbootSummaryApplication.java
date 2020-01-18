package com.devyu;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
//@ComponentScan
//@EnableAutoConfiguration
//@Configuration

@SpringBootApplication
public class SpringbootSummaryApplication {
	public static void main(String[] args) {
		
		// SpringApplication 커스터마이징(web 서버를 사용하지 않고 run 할때)
//		SpringApplication application = new SpringApplication();
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);

//		SpringApplication.run(SpringbootSummaryApplication.class, args);
		
		// 배너 커스터 마이징
		SpringApplication app = new SpringApplication(SpringbootSummaryApplication.class);
		app.setBanner(new Banner() {
			
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				// TODO Auto-generated method stub
				out.println("==============");
				out.println("=== Banner Test ===");
				out.println("==============");
			}
		});
		
		app.setBannerMode(Banner.Mode.OFF); // 배너 끄기
		app.run(args);
	}
}
 
package com.devyu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@TestPropertySource(properties = "devyu.name=mingyu(@TestPropertySource - order.2(properties))")
@TestPropertySource(locations = "classpath:/test.properties")
//@SpringBootTest(properties = "devyu.name=mingyu(@spriongbootTest - order.3)")
@SpringBootTest
class SpringbootSummaryApplicationTests {

	// 기본적으로 모든 propeties는 Environment class를 통해 확인 가능
	@Autowired
	Environment environment;
	
	@Test
	void contextLoads() {
		System.err.println(environment.getProperty("devyu.name"));
//		assertThat(environment.getProperty("devyu.name"))
//						.isEqualTo("mingyu");
	}

}

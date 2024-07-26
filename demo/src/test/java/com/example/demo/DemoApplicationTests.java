package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest // 스프링부트 어플리케이션의 전체 컨텍스트를 로드하여 통합 테스트 실행
class DemoApplicationTests {

	@Autowired // 스프링컨텍스트에서 JdbcTemplate 빈을 주입받는다.
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() { // JdbcTemplate이 스프링 컨텍스트에서 올바르게 주입되었는지 확인
		// Check if jdbcTemplate is not null
		assertNotNull(jdbcTemplate,  // JdbcTemplate 객체가 null이 아님을 확인
				"JdbcTemplate should be auto-wired and not null");
	}
}

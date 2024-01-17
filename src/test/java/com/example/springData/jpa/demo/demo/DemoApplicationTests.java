package com.example.springData.jpa.demo.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private JobService jobService;
	@Test
	void test_get_all_job_with_jdbc_success() {
		var result= jobService.getAllJobs();
		Assertions.assertFalse(result.isEmpty());
	}

}

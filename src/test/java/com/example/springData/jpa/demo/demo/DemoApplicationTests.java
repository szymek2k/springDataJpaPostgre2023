package com.example.springData.jpa.demo.demo;

import com.example.springData.mydatabase.core.entity.Company;
import com.example.springData.mydatabase.core.service.JobService;
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
        var result = jobService.getAllJobs();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void test_get_all_job_with_repository_success() {
        var result = jobService.getAllJobs();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void test_find_all_jobs_by_title_success() {
        var result = jobService.findAllJobs(Company.ORACLE, "anager");
        Assertions.assertFalse(result.isEmpty());
    }

}

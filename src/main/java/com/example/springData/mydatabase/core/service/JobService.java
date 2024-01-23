package com.example.springData.mydatabase.core.service;

import com.example.springData.mydatabase.core.entity.JobEntity;
import com.example.springData.mydatabase.core.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JdbcTemplate jdbcTemplate;
    private final JobRepository jobRepository;

    public List<JobEntity> getAllJobs() {
        return jdbcTemplate.query(
                """ 
                        select company_name as company,
                        experience,
                        title,
                        max_salary,
                        min_salary,
                        id from job 
                        """, BeanPropertyRowMapper.newInstance(JobEntity.class));
    }

    public List<JobEntity> listAllJobs() {
        return jobRepository.findAll();
    }

    public List<JobEntity> findAllJobs(String title) {
        return jobRepository.findAllByTitleContainsIgnoreCase(title);
    }
}

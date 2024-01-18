package com.example.springData.mydatabase.core.service;

import com.example.springData.mydatabase.core.entity.JobEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JdbcTemplate jdbcTemplate;

    public List<JobEntity> getAllJobs() {
        return jdbcTemplate.query("select * from job", BeanPropertyRowMapper.newInstance(JobEntity.class));
    }
}

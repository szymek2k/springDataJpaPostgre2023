package com.example.springData.mydatabase.core.repository;

import com.example.springData.mydatabase.core.entity.JobEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface JobRepository extends ListCrudRepository<JobEntity, Long> {

    List<JobEntity> findAllByTitleContainsIgnoreCase(String title);
}

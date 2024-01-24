package com.example.springData.mydatabase.core.repository;

import com.example.springData.mydatabase.core.entity.Company;
import com.example.springData.mydatabase.core.entity.JobEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends ListCrudRepository<JobEntity, Long> {

    //List<JobEntity> findAllByTitleContainsIgnoreCase(String title);
    //List<JobEntity> findAllByTitleContainsIgnoreCaseAndCompanyOrderByMaxSalaryDesc(String title,Company company);
    @Query(nativeQuery = true, value = "select * from job where lower(title) like concat('%', lower(:p_title), '%') and company_name=:#{#p_company.name()} ")
    List<JobEntity> findAllByFilter(@Param("p_title") String title, @Param("p_company") Company company);
}

package com.example.springData.mydatabase.core.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "job", schema = "public", catalog = "mydatabase")
@Data
@NoArgsConstructor
public class JobEntity {
    @Basic
    @Column(name = "company_name", nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    private Company company;
    @Basic
    @Column(name = "experience", nullable = true, precision = 0)
    private Double experience;
    @Basic
    @Column(name = "title", nullable = true, length = 500)
    private String title;
    @Basic
    @Column(name = "max_salary", nullable = true)
    private Integer maxSalary;
    @Basic
    @Column(name = "min_salary", nullable = true)
    private Integer minSalary;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "job")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<JobHistoryEntity> jobHistories;
}

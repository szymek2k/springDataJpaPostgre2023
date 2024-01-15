package com.example.springData.mydatabase.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "job_history", schema = "public", catalog = "mydatabase")
@Data
public class JobHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "date_from", nullable = true)
    private LocalDate dateFrom;
    @Basic
    @Column(name = "date_to", nullable = true)
    private LocalDate dateTo;
    @Basic
    @Column(name = "salary", nullable = true)
    private Integer salary;
//    @Basic
//    @Column(name = "job_id", nullable = true)
//    private Long jobId;
//    @Basic
//    @Column(name = "person_id", nullable = false)
//    private Long personId;
    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private JobEntity job;
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private PersonEntity person;
}

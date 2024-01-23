package com.example.springData.mydatabase.core.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person", schema = "public", catalog = "mydatabase")
@Data
public class PersonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @Column(name = "first_name", nullable = true, length = 100)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 100)
    private String lastName;
    @Basic
    @Column(name = "phone_number", nullable = true, length = 100)
    private String phoneNumber;
    @OneToMany(mappedBy = "person")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<JobHistoryEntity> jobHistories;
}

package com.example.mcia.inventory.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String fullname;

    @Column String email;

    @Column Date startDate;

    @Column Date leavingDate;

    @ManyToMany Project project;

    @Column String comments;
}

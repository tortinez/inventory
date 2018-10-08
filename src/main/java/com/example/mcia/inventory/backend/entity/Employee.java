package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String fullname;

    @Column String email;

    @Column String position;

    @Column Date startingDate;

    @Column Date leavingDate;

    @Column String comments;

    @ManyToMany Project project;
}

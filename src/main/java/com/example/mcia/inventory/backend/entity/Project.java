package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Project {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String name;

    @Column(unique = true) String code;

    @Column Date startDate;

    @Column Date endDate;

    @ManyToOne Employee manager;

    @ManyToMany License license;

}

package com.example.mcia.inventory.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column String name;

    @Column(unique = true) String code;

    @Column Date startDate;

    @Column Date endDate;

    @ManyToOne Employee manager;


}

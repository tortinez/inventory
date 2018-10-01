package com.example.mcia.inventory.backend.entity;

import javax.persistence.*;

@Entity
public class Location {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String building;

    @Column String floor;

    @Column String office;

    @Column String socket;

}

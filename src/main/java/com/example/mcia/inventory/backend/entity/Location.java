package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Location {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String building;

    @Column String floor;

    @Column String office;

    @Column String networkSocket;

}

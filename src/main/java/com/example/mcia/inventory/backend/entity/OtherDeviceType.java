package com.example.mcia.inventory.backend.entity;

import javax.persistence.*;

@Entity
public class OtherDeviceType {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column private String type;
}

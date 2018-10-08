package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Device {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id protected Long id;

    @Column protected String brand;

    @Column protected String model;

    @Column(unique = true) protected String label;

    @ManyToOne protected Location location;

    @Column protected Date removalDate;
}

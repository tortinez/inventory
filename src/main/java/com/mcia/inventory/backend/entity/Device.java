package com.mcia.inventory.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

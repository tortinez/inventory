package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Supplier {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column private String name;

    @Column private String phone;

    @Column private String CIF;

    @Column private String contact;
}

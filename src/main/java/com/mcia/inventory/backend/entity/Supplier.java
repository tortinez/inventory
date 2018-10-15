package com.mcia.inventory.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supplier {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column private String name;

    @Column private String phone;

    @Column private String CIF;

    @Column private String contact;
}

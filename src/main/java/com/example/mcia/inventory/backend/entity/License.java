package com.example.mcia.inventory.backend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class License {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String name;

    @Column String softwareType;

    @Column String type;

    @Column String dongle;

    @Column Supplier supplier;

    @Column Date dischargeDate;

    @Column Date renewalDate;

    @OneToOne Computer pc;

    //redundant user field, computer has already this field

    @ManyToOne Project project;

}

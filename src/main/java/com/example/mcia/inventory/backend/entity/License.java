package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class License {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String name;

    @Column String softwareType;

    @Column String type;

    @Column String dongle;

    @Column Date activationDate;

    @Column Date renewalDate;

    @Column String renewalType;

    @ManyToOne Supplier supplier;

    @OneToOne Computer pc;

    //redundant user field, computer has already this field

}

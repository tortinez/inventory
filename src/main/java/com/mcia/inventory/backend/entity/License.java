package com.mcia.inventory.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class License {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String name;

    @Column String softwareType;

    @Column String type;

    @Column boolean dongle;

    @Column Date activationDate;

    @Column Date renewalDate;

    @Column String renewalType;

    @ManyToOne Supplier supplier;

    @ManyToMany List<Computer> computer;

    @ManyToMany List<Employee> user;

    @OneToOne Project chargingProject;


    public static final String RESOURCE = "license";

}

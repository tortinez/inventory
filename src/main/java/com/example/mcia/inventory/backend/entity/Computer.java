package com.example.mcia.inventory.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Computer")
public class Computer extends Device{

    @Column private String cpu;

    @Column private String ram;

    @Column private String gpu;

    @Column private String hdd;

    @Column private BigDecimal price;

    @Column private Date purchaseDate;

    @Column private String socket;

    @Column private String specificHardware;

    @Column private Boolean enabled = true;

    @OneToMany private Monitor monitor;

    @ManyToMany private Employee user;  //it can be @ManyToMany?
}

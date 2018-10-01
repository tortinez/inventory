package com.example.mcia.inventory.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Monitor")
public class Monitor extends Device{

    @Column private String resolution;

    @Column private String input;

    @Column private BigDecimal price;

    @Column private Date purchaseDate;

    @Column private Boolean enabled = true;

    @OneToMany private Employee user;  //redundant since computer has already his field
}
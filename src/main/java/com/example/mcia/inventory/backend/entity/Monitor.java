package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "Monitor")
public class Monitor extends Device{

    @Column private String resolution;

    @Column private String input;

    @Column private BigDecimal price;

    @Column private Date purchaseDate;

    @Column private Boolean enabled = true;

    @ManyToMany private Employee user;  //redundant since computer has already his field
}

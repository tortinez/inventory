package com.example.mcia.inventory.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Printer")
public class Printer extends Device{

    @Column private String  cartridgeK;

    @Column private String  cartridgeCMY;

    @Column private String socket;

    @ManyToOne private Employee responsible;
}

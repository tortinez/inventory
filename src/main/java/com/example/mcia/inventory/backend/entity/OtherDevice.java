package com.example.mcia.inventory.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "OtherDevice")
public class OtherDevice extends Device{

    @ManyToOne private OtherDeviceType  type;

    @Column private String socket;

    @ManyToOne private Employee responsible;
}

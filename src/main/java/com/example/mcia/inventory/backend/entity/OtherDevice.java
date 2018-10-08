package com.example.mcia.inventory.backend.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity(name = "OtherDevice")
public class OtherDevice extends Device{

    @Column private String type;

    @Column private String networkSocket;

    @ManyToOne private Employee responsible;
}

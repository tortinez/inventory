package com.mcia.inventory.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OtherDeviceType {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column private String name;


    public static final String RESOURCE = "other-device-type";
}

package com.mcia.inventory.backend.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Location {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column private String building;

    @Column private String floor;

    @Column private String office;

    @Column private String networkSocket;


    public static final String RESOURCE = "location";

}

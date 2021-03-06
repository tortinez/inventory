package com.mcia.inventory.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany private List<NetworkSocket> networkSocket;


    public static final String RESOURCE = "location";

}

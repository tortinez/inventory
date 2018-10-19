package com.mcia.inventory.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NetworkSocket {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column private String label;


    public static final String RESOURCE = "network-socket";
}

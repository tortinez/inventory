package com.mcia.inventory.backend.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class License {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column String name;

    @Column String softwareType;

    @Column String type;

    @Column String dongle;

    @Column Date activationDate;

    @Column Date renewalDate;

    @Column String renewalType;

    @ManyToOne Supplier supplier;

    //redundant user field, computer has already this field

}

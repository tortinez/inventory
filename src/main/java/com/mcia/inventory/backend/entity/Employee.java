package com.mcia.inventory.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;

    @Column private String fullname;

    @Column private String email;

    @Column private String position;

    @Column private Date startingDate;

    @Column private Date leavingDate;

    @Column private String comments;
}

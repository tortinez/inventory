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
public class Project {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Long id;
    
    @Column private String name;
    
    @Column(unique = true) private String code;
    
    @Column private Date startDate;
    
    @Column private Date endDate;
    
    @ManyToOne private Employee manager;

    @OneToMany private List<Employee> employee;


    public static final String RESOURCE = "project";
}

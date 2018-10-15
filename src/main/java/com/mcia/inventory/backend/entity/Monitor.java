package com.mcia.inventory.backend.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity(name = "Monitor")
public class Monitor extends Device{

    @Column private String resolution;

    @Column private String input;

    @Column private BigDecimal price;

    @Column private Date purchaseDate;

    @Column private Boolean enabled = true;

    @ManyToMany private List<Employee> user;  //redundant since computer has already his field


    /*
    Manually generated constructor because Lombok does not support superclasses https://code-examples.net/en/q/1c5cc2e
     */
    public Monitor(Long id, String brand, String model, String label, Location location, Date removalDate,
                   String resolution, String input, BigDecimal price, Date purchaseDate, Boolean enabled, List<Employee> user) {
        super(id, brand, model, label, location, removalDate);
        this.resolution = resolution;
        this.input = input;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.enabled = enabled;
        this.user = user;
    }
}

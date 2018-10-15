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
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity(name = "Computer")
public class Computer extends Device{

    @Column private String cpu;

    @Column private String ram;

    @Column private String gpu;

    @Column private String hdd;

    @Column private BigDecimal price;

    @Column private Date purchaseDate;

    @Column private String networkSocket;

    @Column private String specificHardware;

    @Column private Boolean enabled;

    @OneToMany private List<Monitor> monitor;

    @ManyToMany private List<Employee> user;  //it can be @ManyToMany?

    @ManyToMany private List<License> license;


    /*
    Manually generated constructor because Lombok does not support superclasses https://code-examples.net/en/q/1c5cc2e
     */
    public Computer(Long id, String brand, String model, String label, Location location, Date removalDate, String cpu,
                    String ram, String gpu, String hdd, BigDecimal price, Date purchaseDate, String networkSocket,
                    String specificHardware, Boolean enabled, List<Monitor> monitor, List<Employee> user, List<License> license) {
        super(id, brand, model, label, location, removalDate);
        this.cpu = cpu;
        this.ram = ram;
        this.gpu = gpu;
        this.hdd = hdd;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.networkSocket = networkSocket;
        this.specificHardware = specificHardware;
        this.enabled = enabled;
        this.monitor = monitor;
        this.user = user;
        this.license = license;
    }
}

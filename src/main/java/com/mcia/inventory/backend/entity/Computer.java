package com.mcia.inventory.backend.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

    @Column private String gpu0;

    @Column private String gpu1;

    @Column private String hdd0;

    @Column private String hdd1;

    @Column private String hdd2;

    @Column private BigDecimal price;

    @Column private Date purchaseDate;

    @Column private String specificHardware;

    @Column private Boolean enabled;

    @ManyToMany private List<NetworkSocket> networkSocket;

    @OneToMany private List<Monitor> monitor;

    @ManyToMany private List<Employee> user;


    public static final String RESOURCE = "computer";

    /*
        Manually generated constructor because Lombok does not support superclasses https://code-examples.net/en/q/1c5cc2e
         */
    public Computer(Long id, String brand, String model, String label, Location location, Date removalDate, String cpu,
                    String ram, String gpu0, String gpu1, String hdd0, String hdd1, String hdd2, BigDecimal price,
                    Date purchaseDate, String specificHardware, Boolean enabled, List<NetworkSocket> networkSocket,
                    List<Monitor> monitor, List<Employee> user) {
        super(id, brand, model, label, location, removalDate);
        this.cpu = cpu;
        this.ram = ram;
        this.gpu0 = gpu0;
        this.gpu1 = gpu1;
        this.hdd0 = hdd0;
        this.hdd1 = hdd1;
        this.hdd2 = hdd2;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.specificHardware = specificHardware;
        this.enabled = enabled;
        this.networkSocket = networkSocket;
        this.monitor = monitor;
        this.user = user;
    }
}

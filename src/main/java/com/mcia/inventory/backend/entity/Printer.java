package com.mcia.inventory.backend.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity(name = "Printer")
public class Printer extends Device{

    @Column private String  cartridgeK;

    @Column private String  cartridgeCMY;

    @ManyToMany private List<NetworkSocket> networkSocket;

    @ManyToOne private Employee responsible;


    public static final String RESOURCE = "printer";


    /*
    Manually generated constructor because Lombok does not support superclasses https://code-examples.net/en/q/1c5cc2e
     */
    public Printer(Long id, String brand, String model, String label, Location location, Date removalDate,
                   String cartridgeK, String cartridgeCMY, List<NetworkSocket> networkSocket, Employee responsible) {
        super(id, brand, model, label, location, removalDate);
        this.cartridgeK = cartridgeK;
        this.cartridgeCMY = cartridgeCMY;
        this.networkSocket = networkSocket;
        this.responsible = responsible;
    }
}

package com.mcia.inventory.backend.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity(name = "OtherDevice")
public class OtherDevice extends Device{

    @ManyToOne private OtherDeviceType type;

    @ManyToMany private List<NetworkSocket> networkSocket;

    @ManyToOne private Employee responsible;


    public static final String RESOURCE = "other-device";


    /*
    Manually generated constructor because Lombok does not support superclasses https://code-examples.net/en/q/1c5cc2e
     */
    public OtherDevice(Long id, String brand, String model, String label, Location location, Date removalDate,
                       OtherDeviceType type, List<NetworkSocket> networkSocket, Employee responsible) {
        super(id, brand, model, label, location, removalDate);
        this.type = type;
        this.networkSocket = networkSocket;
        this.responsible = responsible;
    }
}

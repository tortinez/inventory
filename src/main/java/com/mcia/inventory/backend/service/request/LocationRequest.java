package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationRequest {

    private String building;

    private String floor;

    private String office;

    private String networkSocket;
}

package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationRequest {

    private String building;

    private String floor;

    private String office;

    private List<Long> networkSocketId;
}

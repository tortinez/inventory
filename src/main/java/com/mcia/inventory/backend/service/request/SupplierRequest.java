package com.mcia.inventory.backend.service.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequest {

    private String name;

    private String phone;

    private String CIF;

    private String contact;
}

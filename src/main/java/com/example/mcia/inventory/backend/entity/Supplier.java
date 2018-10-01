package com.example.mcia.inventory.backend.entity;

public class Supplier {

    private String name;

    private String phone;

    private String CIF;

    private String contact;

    public Supplier(String name, String phone, String CIF, String contact) {
        this.name = name;
        this.phone = phone;
        this.CIF = CIF;
        this.contact = contact;
    }
}

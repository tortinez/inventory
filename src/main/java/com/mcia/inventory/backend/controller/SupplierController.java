package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Supplier;
import com.mcia.inventory.backend.repository.SupplierRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SupplierController.URI)
public class SupplierController extends BaseController<Supplier>{

    public static final String URI = WebConfig.BASE_API_PATH + "/" + Supplier.RESOURCE;


    protected SupplierController(SupplierRepository repository){
        super(repository);
    }

}
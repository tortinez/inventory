package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.config.WebConfig;
import com.mcia.inventory.backend.entity.Supplier;
import com.mcia.inventory.backend.service.SupplierService;
import com.mcia.inventory.backend.service.request.SupplierRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SupplierController.URI)
public class SupplierController extends BaseController<Supplier, SupplierRequest> {

    static final String URI = WebConfig.BASE_API_PATH + "/" + Supplier.RESOURCE;


    protected SupplierController(SupplierService service) {
        super(SupplierController.URI, service);
    }

}
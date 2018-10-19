package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.entity.Printer;
import com.mcia.inventory.backend.repository.PrinterRepository;
import com.mcia.inventory.backend.service.converter.PrinterConverter;
import com.mcia.inventory.backend.service.request.PrinterRequest;
import org.springframework.stereotype.Service;

@Service
public class PrinterService extends BaseService<Printer, PrinterRequest> {

    public PrinterService(PrinterRepository repository, PrinterConverter converter){
        super(Printer.RESOURCE, repository, converter);
    }

}

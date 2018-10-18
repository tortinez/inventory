package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.*;
import com.mcia.inventory.backend.service.request.EmployeeRequest;
import org.springframework.stereotype.Component;


@Component
public class EmployeeConverter implements RequestConverter<Employee, EmployeeRequest> {

    @Override
    public Employee toEntity(EmployeeRequest request, Long... optId) {
        Long id = (optId[0] != null) ? optId[0] : -1;

        return new Employee(id,
                request.getFullname(),
                request.getEmail(),
                request.getPosition(),
                request.getStartingDate(),
                request.getLeavingDate(),
                request.getComments());
    }


}

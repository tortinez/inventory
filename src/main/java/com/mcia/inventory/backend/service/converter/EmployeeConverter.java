package com.mcia.inventory.backend.service.converter;

import com.mcia.inventory.backend.entity.Employee;
import com.mcia.inventory.backend.service.request.EmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class EmployeeConverter implements RequestConverter<Employee, EmployeeRequest> {

    @Override
    public Employee toEntity(EmployeeRequest request, Long Id) {

        return new Employee(Id,
                request.getFullname(),
                request.getEmail(),
                request.getPosition(),
                request.getStartingDate(),
                request.getLeavingDate(),
                request.getComments());
    }


    @Override
    public Employee toEntity(EmployeeRequest request) {
        return toEntity(request, (long) -1);
    }

}

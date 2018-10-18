package com.mcia.inventory.backend.service.converter;

public interface RequestConverter<T,R> {
    T toEntity(R request, Long... optId);

}

package com.dillian.energymanagement.mappers;

import org.springframework.stereotype.Component;

@Component
public interface DtoMapper<S, T> {

    S toEntity(T dto);

    T toDto(S entity);
}

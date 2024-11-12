package com.example.clinica_veterinaria.mapper;

import com.example.clinica_veterinaria.dto.OwnerDTO;
import com.example.clinica_veterinaria.model.Owner;
import lombok.Builder;

@Builder
public class OwnerMapper {

    public static Owner toModel(OwnerDTO dto) {
        return Owner.builder()
                .dni(dto.dni())
                .name(dto.name())
                .lastName(dto.lastName())
                .phone(dto.phone())
                .build();
    }

    public static OwnerDTO toDTO(Owner entity) {
        return new OwnerDTO(
                entity.getDni(),
                entity.getName(),
                entity.getLastName(),
                entity.getPhone()
        );
    }
}
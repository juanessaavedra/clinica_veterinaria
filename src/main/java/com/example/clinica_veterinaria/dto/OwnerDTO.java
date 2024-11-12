package com.example.clinica_veterinaria.dto;

import lombok.Builder;

@Builder
public record OwnerDTO(
        String dni,
        String name,
        String lastName,
        String phone
) { }
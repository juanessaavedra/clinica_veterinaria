package com.example.clinica_veterinaria.dto;

import lombok.Builder;

@Builder
public record PetDTO(
        String name,
        String species,
        String breed,
        Long ownerId
) { }
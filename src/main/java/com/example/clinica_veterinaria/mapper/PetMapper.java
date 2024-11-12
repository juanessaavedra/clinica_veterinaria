package com.example.clinica_veterinaria.mapper;

import com.example.clinica_veterinaria.dto.PetDTO;
import com.example.clinica_veterinaria.model.Pet;
import com.example.clinica_veterinaria.model.Owner;
import lombok.Builder;

@Builder
public class PetMapper {

    public static Pet toModel(PetDTO dto, Owner owner) {
        return Pet.builder()
                .name(dto.name())
                .species(dto.species())
                .breed(dto.breed())
                .owner(owner)
                .build();
    }

    public static PetDTO toDTO(Pet entity) {
        return new PetDTO(
                entity.getName(),
                entity.getSpecies(),
                entity.getBreed(),
                entity.getOwner().getIdOwner()
        );
    }
}
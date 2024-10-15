package com.example.clinica_veterinaria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetOwnerDTO {

    private String name_pet;
    private String species;
    private String breed;
    private String name_owner;
    private String lastname_owner;

    public PetOwnerDTO() {
    }

    public PetOwnerDTO(String name_pet, String species, String breed, String name_owner, String lastname_owner) {
        this.name_pet = name_pet;
        this.species = species;
        this.breed = breed;
        this.name_owner = name_owner;
        this.lastname_owner = lastname_owner;
    }
}

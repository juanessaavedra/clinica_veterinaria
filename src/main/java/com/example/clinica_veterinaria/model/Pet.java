package com.example.clinica_veterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;
@Getter
@Setter
@RestController

public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_pet;
    private String name;
    private String species;
    private String breed;

    @OneToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "id_owner")
    private Owner owner;

    public Pet() {
    }

    public Pet(String name, String species, String breed, Owner owner) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.owner = owner;
    }
}

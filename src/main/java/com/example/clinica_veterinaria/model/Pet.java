package com.example.clinica_veterinaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPet;

    private String name;
    private String species;
    private String breed;

    @OneToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "idOwner")
    private Owner owner;
}
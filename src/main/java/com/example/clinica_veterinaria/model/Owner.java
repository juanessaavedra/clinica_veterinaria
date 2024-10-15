package com.example.clinica_veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Owner {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Long id_owner;
    private String dni;
    private String name;
    private String last_name;
    private String phone;

    public Owner() {
    }

    public Owner(String dni, String name, String last_name, String phone) {
        this.dni = dni;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
    }
}

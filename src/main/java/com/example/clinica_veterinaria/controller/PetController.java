package com.example.clinica_veterinaria.controller;


import com.example.clinica_veterinaria.dto.PetOwnerDTO;
import com.example.clinica_veterinaria.model.Pet;
import com.example.clinica_veterinaria.service.pet.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private PetServiceImpl petService;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAll();
    }

    @GetMapping("/pet/{id}")
    public Pet getPetById(Long id) {
        return petService.getPetById(id);
    }

    @PostMapping("/pet/create")
    public String savePet (@RequestBody Pet pet) {
        petService.savePet(pet);

        return "The pet was created successfully";
    }

    @PutMapping("/pet/update")
    public Pet updatePet (@RequestBody Pet pet) {
        petService.updatePet(pet);

        return petService.getPetById(pet.getId_pet());
    }

    @DeleteMapping("/pet/delete/{id}")
    public String deletePet (@PathVariable Long id) {
        petService.deletePet(id);

        return "The pet was deleted successfully";
    }


    @GetMapping("/petOwner")
    public List<PetOwnerDTO> getPetOwner() {
        return petService.getPetOwner();
    }

}

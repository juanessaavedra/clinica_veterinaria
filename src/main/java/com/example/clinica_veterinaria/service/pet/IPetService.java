package com.example.clinica_veterinaria.service.pet;

import com.example.clinica_veterinaria.dto.PetOwnerDTO;
import com.example.clinica_veterinaria.model.Pet;

import java.util.List;

public interface IPetService {
    public List<Pet> getAll();

    public Pet getPetById(Long id);

    public void savePet(Pet pet);

    public void deletePet(Long id);

    public void updatePet(Pet pet);

    public List<PetOwnerDTO> getPetOwner();
}

package com.example.clinica_veterinaria.service;

import com.example.clinica_veterinaria.dto.PetDTO;
import java.util.List;

public interface IPetService {
    PetDTO createPet(PetDTO petDTO);
    PetDTO getPetById(Long id);
    List<PetDTO> getAllPets();
    PetDTO updatePet(Long id, PetDTO petDTO);
    void deletePet(Long id);
    List<PetDTO> getPetsByOwnerId(Long ownerId);
}
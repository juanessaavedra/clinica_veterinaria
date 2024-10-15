package com.example.clinica_veterinaria.service.pet;


import com.example.clinica_veterinaria.dto.PetOwnerDTO;
import com.example.clinica_veterinaria.model.Pet;
import com.example.clinica_veterinaria.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetServiceImpl implements IPetService {
    @Autowired
    private IPetRepository petRepository;

    @Override
    public List<Pet> getAll() {
        List<Pet> pets = petRepository.findAll();
        return pets;
    }

    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public void updatePet(Pet pet) {
        this.savePet(pet);
    }

    @Override
    public List<PetOwnerDTO> getPetOwner() {
        List<Pet> pets = this.getAll();
        List<PetOwnerDTO> petOwnerDTOS = new ArrayList<PetOwnerDTO>();
        PetOwnerDTO petOwnerDTO = new PetOwnerDTO();

        for (Pet pet : pets){
            System.out.println(pet.getName());
            petOwnerDTO.setName_owner(pet.getOwner().getName());
            petOwnerDTO.setName_pet(pet.getName());
            petOwnerDTO.setLastname_owner(pet.getOwner().getLast_name());
            petOwnerDTO.setSpecies(pet.getSpecies());
            petOwnerDTO.setBreed(pet.getBreed());

            petOwnerDTOS.add(petOwnerDTO);
            petOwnerDTO = new PetOwnerDTO(); //reset
        }
        return petOwnerDTOS;
    }
}

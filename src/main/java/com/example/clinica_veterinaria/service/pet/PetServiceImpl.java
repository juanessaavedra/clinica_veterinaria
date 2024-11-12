package com.example.clinica_veterinaria.service.pet;

import com.example.clinica_veterinaria.dto.PetDTO;
import com.example.clinica_veterinaria.mapper.PetMapper;
import com.example.clinica_veterinaria.model.Owner;
import com.example.clinica_veterinaria.model.Pet;
import com.example.clinica_veterinaria.repository.IOwnerRepository;
import com.example.clinica_veterinaria.repository.IPetRepository;
import com.example.clinica_veterinaria.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements IPetService {

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        Owner owner = ownerRepository.findById(petDTO.ownerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        Pet pet = PetMapper.toModel(petDTO, owner);
        Pet savedPet = petRepository.save(pet);
        return PetMapper.toDTO(savedPet);
    }

    @Override
    public PetDTO getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        return PetMapper.toDTO(pet);
    }

    @Override
    public List<PetDTO> getAllPets() {
        return petRepository.findAll().stream()
                .map(PetMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PetDTO updatePet(Long id, PetDTO petDTO) {
        Pet existingPet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        Owner owner = ownerRepository.findById(petDTO.ownerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        Pet petToUpdate = PetMapper.toModel(petDTO, owner);
        petToUpdate.setIdPet(id);

        Pet updatedPet = petRepository.save(petToUpdate);
        return PetMapper.toDTO(updatedPet);
    }

    @Override
    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            throw new RuntimeException("Pet not found");
        }
        petRepository.deleteById(id);
    }

    @Override
    public List<PetDTO> getPetsByOwnerId(Long ownerId) {
        return petRepository.findById(ownerId).stream()
                .map(PetMapper::toDTO)
                .collect(Collectors.toList());
    }
}
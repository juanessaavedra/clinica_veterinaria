package com.example.clinica_veterinaria.controller;

import com.example.clinica_veterinaria.dto.PetDTO;
import com.example.clinica_veterinaria.service.pet.PetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "*")
public class PetController {

    @Autowired
    private PetServiceImpl petService;

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO petDTO) {
        PetDTO createdPet = petService.createPet(petDTO);
        return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        PetDTO pet = petService.getPetById(id);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<PetDTO> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<PetDTO>> getPetsByOwnerId(@PathVariable Long ownerId) {
        List<PetDTO> pets = petService.getPetsByOwnerId(ownerId);
        return ResponseEntity.ok(pets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Long id, @RequestBody PetDTO petDTO) {
        PetDTO updatedPet = petService.updatePet(id, petDTO);
        return ResponseEntity.ok(updatedPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
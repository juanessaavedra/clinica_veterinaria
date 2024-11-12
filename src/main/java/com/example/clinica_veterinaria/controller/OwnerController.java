package com.example.clinica_veterinaria.controller;

import com.example.clinica_veterinaria.dto.OwnerDTO;
import com.example.clinica_veterinaria.service.owner.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO ownerDTO) {
        OwnerDTO createdOwner = ownerService.createOwner(ownerDTO);
        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id) {
        OwnerDTO owner = ownerService.getOwnerById(id);
        return ResponseEntity.ok(owner);
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> getAllOwners() {
        List<OwnerDTO> owners = ownerService.getAllOwners();
        return ResponseEntity.ok(owners);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> updateOwner(@PathVariable Long id, @RequestBody OwnerDTO ownerDTO) {
        OwnerDTO updatedOwner = ownerService.updateOwner(id, ownerDTO);
        return ResponseEntity.ok(updatedOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.noContent().build();
    }
}
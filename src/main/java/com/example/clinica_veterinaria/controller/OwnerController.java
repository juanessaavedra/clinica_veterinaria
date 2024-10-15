package com.example.clinica_veterinaria.controller;

import com.example.clinica_veterinaria.model.Owner;
import com.example.clinica_veterinaria.service.owner.OwnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @GetMapping("/owners")
    public List<Owner> getAllOwners() {
        return ownerService.getAll();
    }

    @GetMapping("/owner/{id}")
    public Owner getOwnerById(Long id) {
        return ownerService.getOwnerById(id);
    }

    @PostMapping("/owner/create")
    public String savePersona (@RequestBody Owner owner) {
        ownerService.saveOwner(owner);

        return "The owner was created successfully";
    }

    @PutMapping("/owner/update")
    public Owner updateOwner (@RequestBody Owner owner) {
        ownerService.updateOwner(owner);

        return ownerService.getOwnerById(owner.getId_owner());
    }

    @DeleteMapping("/owner/delete/{id}")
    public String deleteOwner (@PathVariable Long id) {
        ownerService.deleteOwner(id);

        return "The owner was deleted successfully";
    }
}



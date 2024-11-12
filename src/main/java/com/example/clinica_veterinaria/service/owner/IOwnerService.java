package com.example.clinica_veterinaria.service.owner;

import com.example.clinica_veterinaria.dto.OwnerDTO;
import com.example.clinica_veterinaria.model.Owner;

import java.util.List;

public interface IOwner {

    OwnerDTO createOwner(OwnerDTO ownerDTO);
    OwnerDTO getOwnerById(Long id);
    List<OwnerDTO> getAllOwners();
    OwnerDTO updateOwner(Long id, OwnerDTO ownerDTO);
    void deleteOwner(Long id);
}

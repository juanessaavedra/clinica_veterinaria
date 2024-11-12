package com.example.clinica_veterinaria.service.owner;

import com.example.clinica_veterinaria.dto.OwnerDTO;
import com.example.clinica_veterinaria.mapper.OwnerMapper;
import com.example.clinica_veterinaria.model.Owner;
import com.example.clinica_veterinaria.repository.IOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class OwnerServiceImpl implements IOwnerService {

    @Autowired
    private IOwnerRepository ownerRepository;

    @Override
    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner owner = OwnerMapper.toModel(ownerDTO);
        Owner savedOwner = ownerRepository.save(owner);
        return OwnerMapper.toDTO(savedOwner);
    }

    @Override
    public OwnerDTO getOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        return OwnerMapper.toDTO(owner);
    }

    @Override
    public List<OwnerDTO> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(OwnerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDTO updateOwner(Long id, OwnerDTO ownerDTO) {
        Owner existingOwner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        Owner ownerToUpdate = OwnerMapper.toModel(ownerDTO);
        ownerToUpdate.setIdOwner(id);

        Owner updatedOwner = ownerRepository.save(ownerToUpdate);
        return OwnerMapper.toDTO(updatedOwner);
    }

    @Override
    public void deleteOwner(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new RuntimeException("Owner not found");
        }
        ownerRepository.deleteById(id);
    }
}
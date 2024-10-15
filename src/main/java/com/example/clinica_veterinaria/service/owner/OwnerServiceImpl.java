package com.example.clinica_veterinaria.service.owner;

import com.example.clinica_veterinaria.model.Owner;
import com.example.clinica_veterinaria.repository.IOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements IOwner {

    @Autowired
    private IOwnerRepository ownerRepository;


    @Override
    public List<Owner> getAll() {
        List<Owner> owners = ownerRepository.findAll();
        return owners;
    }

    @Override
    public Owner getOwnerById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public void updateOwner(Owner owner) {
        this.saveOwner(owner);
    }
}

package com.example.clinica_veterinaria.service.owner;

import com.example.clinica_veterinaria.model.Owner;

import java.util.List;

public interface IOwner {

    public List<Owner> getAll();

    public Owner getOwnerById(Long id);

    public void saveOwner(Owner owner);

    public void deleteOwner(Long id);

    public void updateOwner(Owner owner);
}

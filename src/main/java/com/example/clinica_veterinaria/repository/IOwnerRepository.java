package com.example.clinica_veterinaria.repository;

import com.example.clinica_veterinaria.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

}

package com.example.demoPFE.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoPFE.models.Equipement;
@Repository
public interface equipement_repo extends JpaRepository<Equipement, Long> {

}

package com.example.demoPFE.repo;

import org.springframework.stereotype.Repository;

import com.example.demoPFE.models.Demande;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface demande_repo extends JpaRepository<Demande , Long> {

}

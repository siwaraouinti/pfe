package com.example.demoPFE.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoPFE.models.Utilisateur ;
@Repository
public interface utilisateur_repo extends JpaRepository<Utilisateur ,Long>  {

}

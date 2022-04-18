package com.example.demoPFE.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPFE.Exeptions.roleExeption;
import com.example.demoPFE.Exeptions.utilisateurExeption;
import com.example.demoPFE.models.Role;
import com.example.demoPFE.models.Utilisateur;
import com.example.demoPFE.repo.utilisateur_repo;

@Service
@Transactional
public class utilisateur_service {
	private final utilisateur_repo utilisateur_repo;
    @Autowired
    public utilisateur_service(utilisateur_repo utilisateur_repo){
        this.utilisateur_repo=utilisateur_repo;
    }
    public Utilisateur add (Utilisateur e){
        return utilisateur_repo.save(e);
    }

    public List<Utilisateur>getall(){
        return utilisateur_repo.findAll();
    }
    
    public Utilisateur getutilisateur (Long idutilisateur){
        return utilisateur_repo.findById(idutilisateur).orElseThrow(() ->
        new utilisateurExeption(idutilisateur));
    }
    public Utilisateur modif (Utilisateur e){
        return utilisateur_repo.save(e);
    }
	
    public void delete (Long idutilisateur){
        utilisateur_repo.deleteById(idutilisateur);
    }
	
}

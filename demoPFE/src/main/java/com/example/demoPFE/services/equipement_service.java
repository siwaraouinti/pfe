package com.example.demoPFE.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPFE.Exeptions.equipementExeption;
import com.example.demoPFE.Exeptions.roleExeption;
import com.example.demoPFE.models.Equipement;
import com.example.demoPFE.models.Role;
import com.example.demoPFE.repo.*;
@Service
@Transactional
public class equipement_service {
	private final equipement_repo equipement_repo;
    @Autowired
    public equipement_service(equipement_repo equipement_repo){
        this.equipement_repo=equipement_repo;
    }
    public Equipement add (Equipement e){
        return equipement_repo.save(e);
    }

    public List<Equipement>getall(){
        return equipement_repo.findAll();
    }
    public Equipement getequipement (Long idequipement){
        return equipement_repo.findById(idequipement).orElseThrow(() ->
        new equipementExeption(idequipement));
    }
    public Equipement modif (Long idequipement,Equipement e){
    	Equipement equipementtoedit=getequipement(idequipement); 
    	equipementtoedit.setIntitulé(e.getIntitulé());
    	equipementtoedit.setTypeequipement(e.getIntitulé());
        return equipementtoedit;
    }
	
    public void delete (Long idequipement){
        equipement_repo.deleteById(idequipement);
    }
	
}

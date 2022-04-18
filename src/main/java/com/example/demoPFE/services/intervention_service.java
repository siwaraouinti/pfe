package com.example.demoPFE.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPFE.Exeptions.interventionExeption;
import com.example.demoPFE.models.Intervention;
import com.example.demoPFE.repo.intervention_repo;

@Service
@Transactional
public class intervention_service {
	private final intervention_repo intervention_repo;
    @Autowired
    public intervention_service(intervention_repo intervention_repo){
        this.intervention_repo=intervention_repo;
    }
    public Intervention add (Intervention e){
        return intervention_repo.save(e);
    }

    public List<Intervention>getall(){
        return intervention_repo.findAll();
    }
    
    public Intervention getintervention (Long idintervention){
        return intervention_repo.findById(idintervention).orElseThrow(() ->
        new interventionExeption(idintervention));
    }
    public Intervention modif (Long idintervention,Intervention e){
    	Intervention interventiontoedit=getintervention(idintervention); 
    	interventiontoedit.setDescription(e.getDescription());
    	interventiontoedit.setDate_deb(e.getDate_deb());
    	interventiontoedit.setEtat(e.getEtat());
    	interventiontoedit.setMotif(e.getMotif());
    	interventiontoedit.setDate_fin(e.getDate_fin());
        return interventiontoedit;
    }
    public void delete (Long idintervention){
        intervention_repo.deleteById(idintervention);
    }
	
}

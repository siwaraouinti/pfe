package com.example.demoPFE.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demoPFE.models.*;

import com.example.demoPFE.models.Intervention;

import com.example.demoPFE.services.*;


@RestController
@RequestMapping("/intervention")
public class interventionController {
	private final intervention_service intervention_service;
	private final demande_service demande_service;
	private final utilisateur_service utilisateur_service;
    public interventionController(intervention_service intervention_service,demande_service demande_service,utilisateur_service utilisateur_service){
        this.intervention_service=intervention_service;
        this.demande_service=demande_service;
        this.utilisateur_service=utilisateur_service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Intervention>>get_all()
    {
        List<Intervention> List =intervention_service.getall();
        if (List.size()==0)
            return  ResponseEntity.status(204).body(List);
        return  ResponseEntity.ok().body(List);
    }
    @PostMapping("/add/{iddemande}/intervenant/{idutilisateur}")
    public ResponseEntity<Intervention> addintervention(
    		@RequestBody Intervention e,
    		@PathVariable("iddemande") Long iddemande,
    		@PathVariable("idutilisateur") Long idutilisateur)
    {
    	
         Demande demande = demande_service.getdemande(iddemande);
         Utilisateur utilisateur = utilisateur_service.getutilisateur(idutilisateur);
         e.assigndemande(demande);
         //e.assignuser(utilisateur);
         Intervention e2=intervention_service.add(e); 
         return new ResponseEntity<>(e2,HttpStatus.CREATED);


    }
    @PutMapping("/{idintervention}/put")
    public ResponseEntity<Intervention> put(@PathVariable("idintervention") Long idintervention,
    		@RequestBody Intervention e){
        Intervention e1=intervention_service.modif(idintervention,e);
        return new ResponseEntity<>(e1,HttpStatus.OK);


    }
    @DeleteMapping("/delete/{idintervention}")
    public ResponseEntity<?> delete(@PathVariable("idintervention") Long idintervention ){
    	intervention_service.delete(idintervention);
        return new ResponseEntity<>(HttpStatus.OK);


    }

}

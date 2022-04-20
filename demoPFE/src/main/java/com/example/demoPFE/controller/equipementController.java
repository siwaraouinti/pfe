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

import com.example.demoPFE.models.Equipement;
import com.example.demoPFE.services.*;
@RestController
@RequestMapping("/equipement")

public class equipementController {
	 private final equipement_service equipement_service;
	    public equipementController(equipement_service equipement_service){
	        this.equipement_service=equipement_service;
	    }
	    @GetMapping("/all")
	    public ResponseEntity<List<Equipement>>get_all()
	    {
	        List<Equipement> List =equipement_service.getall();
	        if (List.size()==0)
	            return  ResponseEntity.status(204).body(List);
	        return  ResponseEntity.ok().body(List);
	    }
	    @PostMapping("/add")
	    public ResponseEntity<Equipement> addequipement(@RequestBody Equipement e){
	        Equipement e1=equipement_service.add(e);
	        return new ResponseEntity<>(e1,HttpStatus.CREATED);


	    }
	    @PutMapping("/put/{idequipement}")
	    public ResponseEntity<Equipement> put(@PathVariable Long idequipement ,@RequestBody Equipement e){
	        Equipement e1=equipement_service.modif(idequipement,e);
	        return new ResponseEntity<>(e1,HttpStatus.OK);


	    }
	    @DeleteMapping("/delete/{idequipement}")
	    public ResponseEntity<?> delete(@PathVariable("idequipement") Long idequipement ){
	    	equipement_service.delete(idequipement);
	        return new ResponseEntity<>(HttpStatus.OK);


	    }

	    
}

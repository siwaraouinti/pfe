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

import com.example.demoPFE.models.Categorie;
import com.example.demoPFE.services.categorie_service;

@RestController
@RequestMapping("/categorie")
public class categorieController {
	private final categorie_service categorie_service;
    public categorieController(categorie_service categorie_service){
        this.categorie_service=categorie_service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Categorie>>get_all()
    {
        List<Categorie> List =categorie_service.getall();
        if (List.size()==0)
            return  ResponseEntity.status(204).body(List);
        return  ResponseEntity.ok().body(List);
    }
    @PostMapping("/add")
    public ResponseEntity<Categorie> addequipement(@RequestBody Categorie e){
        Categorie e1=categorie_service.add(e);
        return new ResponseEntity<>(e1,HttpStatus.CREATED);


    }
    @PutMapping("/put")
    public ResponseEntity<Categorie> put(@PathVariable Long idcategorie, @RequestBody Categorie e){
    	Categorie e1=categorie_service.modif(idcategorie,e);
        return new ResponseEntity<>(e1,HttpStatus.OK);


    }
    @DeleteMapping("/delete/{idcategorie}")
    public ResponseEntity<?> delete(@PathVariable("idcategorie") Long idcategorie ){
    	categorie_service.delete(idcategorie);
        return new ResponseEntity<>(HttpStatus.OK);


    }

    
}

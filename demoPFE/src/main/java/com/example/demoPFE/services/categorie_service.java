package com.example.demoPFE.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPFE.Exeptions.categorieExeption;
import com.example.demoPFE.models.Categorie;
import com.example.demoPFE.models.Categorie;
import com.example.demoPFE.repo.categorie_repo;

@Service
@Transactional
public class categorie_service {
	private final categorie_repo categorie_repo;
    @Autowired
    public categorie_service(categorie_repo categorie_repo){
        this.categorie_repo=categorie_repo;
    }
    public Categorie add (Categorie e){
        return categorie_repo.save(e);
    }

    public List<Categorie>getall(){
        return categorie_repo.findAll();
    }
    public Categorie getcategorie (Long idcategorie){
        return categorie_repo.findById(idcategorie).orElseThrow(() ->
        new categorieExeption(idcategorie));
    }
    public Categorie modif (Long idcategorie,Categorie e){
    	Categorie categorietoedit=getcategorie(idcategorie); 
    	categorietoedit.setTypemaintenance(e.getTypemaintenance());
    	
        return categorietoedit;
    }
	
	
    public void delete (Long idcategorie){
    	categorie_repo.deleteById(idcategorie);
    }
	
}

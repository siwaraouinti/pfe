package com.example.demoPFE.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPFE.Exeptions.demandeExeption;
import com.example.demoPFE.models.Demande;
import com.example.demoPFE.models.Intervention;
import com.example.demoPFE.repo.demande_repo;

@Service
@Transactional
public class demande_service {
	private final demande_repo demande_repo;
    @Autowired
    public demande_service(demande_repo demande_repo){
        this.demande_repo=demande_repo;
    }
    public Demande add (Demande e){
        return demande_repo.save(e);
    }

    public List<Demande>getall(){
        return demande_repo.findAll();
    }
    
    public Demande getdemande (Long iddemande){
        return demande_repo.findById(iddemande).orElseThrow(() ->
        new demandeExeption(iddemande));
    }
    public Demande modif (Long iddemande,Demande e){
    	Demande demandetoedit=getdemande(iddemande); 
    	demandetoedit.setDescription(e.getDescription());
    	demandetoedit.setAdressePanne(e.getAdressePanne());
    	demandetoedit.setPriorite(e.getPriorite());
        return demandetoedit;
    }
    public void delete (Long iddemande){
        demande_repo.deleteById(iddemande);
    }
	
}


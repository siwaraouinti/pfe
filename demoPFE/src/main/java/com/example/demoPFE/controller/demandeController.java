package com.example.demoPFE.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.example.demoPFE.models.Demande;
import com.example.demoPFE.models.*;

import com.example.demoPFE.models.Categorie;
import com.example.demoPFE.models.Utilisateur;
import com.example.demoPFE.services.demande_service;
import com.example.demoPFE.services.*;

@RestController
@RequestMapping("/demande")
public class demandeController {
	private final demande_service demande_service;
	private final utilisateur_service utilisateur_service;
	private final equipement_service equipement_service;
	private final categorie_service categorie_service;
	private final notif_service notif_service;
    public demandeController(demande_service demande_service,notif_service notif_service ,utilisateur_service utilisateur_service,equipement_service equipement_service,categorie_service categorie_service){
        this.demande_service=demande_service;
        this.utilisateur_service=utilisateur_service;
        this.equipement_service=equipement_service;
        this.categorie_service=categorie_service;
        this.notif_service=notif_service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Demande>>get_all()
    {
        List<Demande> List =demande_service.getall();
        if (List.size()==0)
            return  ResponseEntity.status(204).body(List);
        return  ResponseEntity.ok().body(List);
    }
    @GetMapping("/recherche/{chaine}")
    public ResponseEntity<List<Demande>> get_recherche(@PathVariable("chaine") String chaine){
    	List<Demande> demandes =demande_service.getall();  
    	
    	List<Demande> d =new ArrayList<Demande>();
    	for(int i=0;i<demandes.size();i++){
    if (chaine.equals(demandes.get(i).getAdressePanne())||chaine.equals(demandes.get(i).getDescription())||chaine.equals(demandes.get(i).getPriorite())){
     d.add(demandes.get(i));
     
     }
     }
    	
    	 return  ResponseEntity.ok().body(d);
		
    }
    @PostMapping("/add/{idutilisateur}/{idequipement}/{idcategorie}")
    public ResponseEntity<Demande> adddemande(@RequestBody Demande e
    		,@PathVariable("idutilisateur") Long idutilisateur,
    		@PathVariable("idequipement") Long idequipement,
    		@PathVariable("idcategorie") Long idcategorie){
    	 Utilisateur utilisateur= utilisateur_service.getutilisateur(idutilisateur);
         Equipement equipement= equipement_service.getequipement(idequipement);
         Categorie categorie= categorie_service.getcategorie(idcategorie);
         e.assigncategorie(categorie);
         e.assignutilisateur(utilisateur);
         e.assignequipement(equipement);
         Demande e2=demande_service.add(e); 
         Notif nn =new Notif();
        nn.setChaine("une nouvelle notification");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String date=dtf.format(now);
        nn.setDatee(date);
        nn.setSeen("0");
        nn.assignsender(utilisateur);
        Notif n=notif_service.add(nn);
        return new ResponseEntity<>(e2,HttpStatus.CREATED);


    }
    @PutMapping("/{iddemande}/put")
    public ResponseEntity<Demande> put(@PathVariable("iddemande") Long iddemande,
    		@RequestBody Demande e){
        Demande e1=demande_service.modif(iddemande,e);
        return new ResponseEntity<>(e1,HttpStatus.OK);


    }
    @DeleteMapping("/delete/{iddemande}")
    public ResponseEntity<?> delete(@PathVariable("iddemande") Long iddemande ){
    	demande_service.delete(iddemande);
        return new ResponseEntity<>(HttpStatus.OK);


    }
    

}

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

import com.example.demoPFE.models.Notif;
import com.example.demoPFE.models.Utilisateur;
import com.example.demoPFE.services.notif_service;
import com.example.demoPFE.services.utilisateur_service;
@RestController
@RequestMapping("/notification")
public class notificationController {
	private final notif_service notif_service;
	private final utilisateur_service utilisateur_service;
    public notificationController(notif_service notif_service,utilisateur_service utilisateur_service){
        this.notif_service=notif_service;
        this.utilisateur_service = utilisateur_service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Notif>>get_all()
    {
        List<Notif> List =notif_service.getall();
        if (List.size()==0)
            return  ResponseEntity.status(204).body(List);
        return  ResponseEntity.ok().body(List);
    }
    @PostMapping("/add/{idutilisateur}")
    public ResponseEntity<Notif> addnotification(@RequestBody Notif e,
    		@PathVariable Long idutilisateur){
        Utilisateur utilisateur = utilisateur_service.getutilisateur(idutilisateur);
        e.assignsender(utilisateur);
    	Notif e1=notif_service.add(e);
        return new ResponseEntity<>(e1,HttpStatus.CREATED);


    }
    @GetMapping("/count")
    public int count(){
    	 List<Notif> List =notif_service.getall();
    	 int j=0;
    	 for(int i=0;i<List.size();i++) {
    	if (List.get(i).getSeen().equals("0")) {
    		j++;
    	}
    	 }
    	return j;
    }
    @PutMapping("/update/all")
    public ResponseEntity<List<Notif>>putall(){
    	 List<Notif> List =notif_service.getall();
    	 for(int i=0;i<List.size();i++) {
    		 
    		List.get(i).setSeen("1");
    		
    		 Notif e1=notif_service.modif(List.get(i).getIdnotif(),List.get(i));
    		 
    		}
    	
    	 return  ResponseEntity.ok().body(List);
    }
    
    
    
    @PutMapping("/{idnotif}/put")
    public ResponseEntity<Notif> put(@PathVariable("idnotif") Long idnotif,
    		@RequestBody Notif e){
        Notif e1=notif_service.modif(idnotif,e);
        return new ResponseEntity<>(e1,HttpStatus.OK);


    }
    @DeleteMapping("/delete/{idnotif}")
    public ResponseEntity<?> delete(@PathVariable("idnotif") Long idnotif){
    	notif_service.delete(idnotif);
        return new ResponseEntity<>(HttpStatus.OK);


    }
}

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


import com.example.demoPFE.models.Utilisateur;
import com.example.demoPFE.models.Role;


import com.example.demoPFE.services.*;

@RestController
@RequestMapping("/utilisateur")
public class utilisateurController {
	private final utilisateur_service utilisateur_service;
	
	private final role_service role_service;
    public utilisateurController(utilisateur_service utilisateur_service,role_service role_service){
        this.utilisateur_service=utilisateur_service;
		this.role_service=role_service;
		
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Utilisateur>>get_all()
    {
        List<Utilisateur> List =utilisateur_service.getall();
        if (List.size()==0)
            return  ResponseEntity.status(204).body(List);
        return  ResponseEntity.ok().body(List);
    }
    @PostMapping("/add/{idrole}")
    public ResponseEntity<Utilisateur> addutilisateur(
    		@RequestBody Utilisateur e,
    		@PathVariable("idrole") Long idrole )
    {
    	
         Role r= role_service.getrole(idrole);
         e.assignrole(r);
         Utilisateur e2=utilisateur_service.add(e); 
         return new ResponseEntity<>(e2,HttpStatus.CREATED);


    }
    @PutMapping("/put")
    public ResponseEntity<Utilisateur> put(@RequestBody Utilisateur e){
        Utilisateur e1=utilisateur_service.modif(e);
        return new ResponseEntity<>(e1,HttpStatus.OK);


    }
    @DeleteMapping("/delete/{idutilisateur}")
    public ResponseEntity<?> delete(@PathVariable("idutilisateur") Long idutilisateur ){
    	utilisateur_service.delete(idutilisateur);
        return new ResponseEntity<>(HttpStatus.OK);


    }

//    @PutMapping("/{idutilisateur}/role/{idrole}")
//    public Utilisateur assignRoleToUtilisateur(
//    		@PathVariable("idutilisateur") Long idutilisateur,
//    		@PathVariable("idrole") Long idrole
//    		){
//        Utilisateur utilisateur=utilisateur_service.getutilisateur(idutilisateur);
//      
//        Role role=role_service.getrole(idrole);
//       utilisateur.assignrole(role);
//       Utilisateur e1=utilisateur_service.add(utilisateur); 
//       return (e1);
//}
//    
}

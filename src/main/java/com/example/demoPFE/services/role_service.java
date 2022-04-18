package com.example.demoPFE.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPFE.Exeptions.roleExeption;
import com.example.demoPFE.models.Role;
import com.example.demoPFE.repo.role_repo;

@Service
@Transactional
public class role_service {
	private final role_repo role_repo;
    @Autowired
    public role_service(role_repo role_repo){
        this.role_repo=role_repo;
    }
    public Role add (Role e){
        return role_repo.save(e);
    }

    public List<Role>getall(){
        return role_repo.findAll();
    }
    
    public Role getrole (Long idrole){
        return role_repo.findById(idrole).orElseThrow(() ->
        new roleExeption(idrole));
    }
    public Role modif (Long idrole,Role e){
    	Role roletoedit=getrole(idrole); 
    	roletoedit.setDesignation(e.getDesignation());
        return roletoedit;
    }
    public void delete (Long idrole){
        role_repo.deleteById(idrole);
    }
	
}

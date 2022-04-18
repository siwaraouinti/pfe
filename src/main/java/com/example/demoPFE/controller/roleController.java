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

import com.example.demoPFE.models.Role;
import com.example.demoPFE.services.role_service;

@RestController
@RequestMapping("/role")
public class roleController {
	private final role_service role_service;
    public roleController(role_service role_service){
        this.role_service=role_service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Role>>get_all()
    {
        List<Role> List =role_service.getall();
        if (List.size()==0)
            return  ResponseEntity.status(204).body(List);
        return  ResponseEntity.ok().body(List);
    }
    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role e){
        Role e1=role_service.add(e);
        return new ResponseEntity<>(e1,HttpStatus.CREATED);


    }
    @PutMapping("/{idrole}/put")
    public ResponseEntity<Role> put(@PathVariable("idrole") Long idrole,
    		@RequestBody Role e){
        Role e1=role_service.modif(idrole,e);
        return new ResponseEntity<>(e1,HttpStatus.OK);


    }
    @DeleteMapping("/delete/{idrole}")
    public ResponseEntity<?> delete(@PathVariable("idrole") Long idrole ){
    	role_service.delete(idrole);
        return new ResponseEntity<>(HttpStatus.OK);


    }

}

package com.example.demoPFE.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoPFE.Exeptions.notificationExeption;
import com.example.demoPFE.models.Notif;
import com.example.demoPFE.repo.notif_repo;
@Service
@Transactional
public class notif_service {
	private final notif_repo notif_repo;
    @Autowired
    public notif_service(notif_repo notif_repo){
        this.notif_repo=notif_repo;
    }
    public Notif add (Notif e){
        return notif_repo.save(e);
    }

    public List<Notif>getall(){
        return notif_repo.findAll();
    }
    
    public Notif getnotif(Long idnotif){
        return notif_repo.findById(idnotif).orElseThrow(() ->
        new notificationExeption(idnotif));
    }
    public Notif modif (Long idnotif,Notif e){
    	Notif notificationtoedit=getnotif(idnotif);
    	notificationtoedit.setChaine(e.getChaine());
    	notificationtoedit.setDatee(e.getDatee());
    	
    	notificationtoedit.setSeen(e.getSeen());
        return notificationtoedit;
    }
    public void delete (Long idnotif){
        notif_repo.deleteById(idnotif);
    }
	
}

package com.example.demoPFE.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Categorie {
	public Categorie() {
	
	}
	public Categorie(String typemaintenance) {
		
		this.typemaintenance = typemaintenance;
	}
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
    private Long idcategorie ;
    @Column(length = 60)
    private String typemaintenance;
    
public Set<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}
@JsonIgnore
@OneToMany(mappedBy="categorie")
private Set<Demande> demandes = new HashSet<>();
	public Long getIdcategorie() {
		return idcategorie;
	}
	public void setIdcategorie(Long idcategorie) {
		this.idcategorie = idcategorie;
	}
	public String getTypemaintenance() {
		return typemaintenance;
	}
	public void setTypemaintenance(String typemaintenance) {
		this.typemaintenance = typemaintenance;
	}


}

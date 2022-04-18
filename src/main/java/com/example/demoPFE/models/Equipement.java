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

public class Equipement {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
    private Long idequipement ;
    @Column(length = 60)
    private String intitulé;

    @Column(length = 60)
    private String typeequipement;

    
@JsonIgnore
@OneToMany(mappedBy="equipement")
private Set<Demande> demandes = new HashSet<>();
	public Set<Demande> getDemandes() {
	return demandes;
}

public void setDemandes(Set<Demande> demandes) {
	this.demandes = demandes;
}

	public Equipement() {
		
	}

	public Equipement(String intitulé, String typeequipement) {
		
		this.intitulé = intitulé;
		this.typeequipement = typeequipement;
	}

	public Long getIdequipement() {
		return idequipement;
	}

	public void setIdequipement(Long idequipement) {
		this.idequipement = idequipement;
	}

	public String getIntitulé() {
		return intitulé;
	}

	public void setIntitulé(String intitulé) {
		this.intitulé = intitulé;
	}

	public String getTypeequipement() {
		return typeequipement;
	}

	public void setTypeequipement(String typeequipement) {
		this.typeequipement = typeequipement;
	}
}
	

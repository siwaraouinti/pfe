package com.example.demoPFE.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Demande {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iddemande;
	private String description;
	private String adressePanne;
	private String priorite;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idutilisateur",referencedColumnName="idutilisateur")
	private Utilisateur utilisateur;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ideequipement",referencedColumnName="idequipement")
	private Equipement equipement;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idcategorie",referencedColumnName="idcategorie")
	private Categorie categorie;
	@JsonIgnore
	@OneToMany(mappedBy="demande")
	private Set<Intervention> interventions = new HashSet<>();
	public Set<Intervention> getInterventions() {
		return interventions;
	}
	public void setInterventions(Set<Intervention> interventions) {
		this.interventions = interventions;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Equipement getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	public Long getIddemande() {
		return iddemande;
	}
	public void setIddemande(Long iddemande) {
		this.iddemande = iddemande;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdressePanne() {
		return adressePanne;
	}
	public void setAdressePanne(String adressePanne) {
		this.adressePanne = adressePanne;
	}
	public String getPriorite() {
		return priorite;
	}
	public void setPriorite(String priorite) {
		this.priorite = priorite;
	}
	public Demande(String description, String adressePanne, String priorite) {
		
		this.description = description;
		this.adressePanne = adressePanne;
		this.priorite = priorite;
	}
	public Demande() {
		
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public void assignutilisateur(Utilisateur utilisateur) {
	
	   this.utilisateur=utilisateur;	
	}
	public void assignequipement(Equipement equipement) {
		// TODO Auto-generated method stub
		this.equipement=equipement;
	}
	public void assigncategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		this.categorie=categorie;
	}
	
	
	
}

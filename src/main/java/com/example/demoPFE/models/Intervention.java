package com.example.demoPFE.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Intervention {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
    private Long idintervention ;
    @Column(length = 60)
    private String description;
    @Column(length = 60)
    private String date_deb;
    @Column(length = 60)
    private String etat;
    @Column(length = 60)
    private String motif;
    @Column(length = 60)
    private String date_fin;
    public String getMotif() {
		return motif;
	}
    
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iddemande",referencedColumnName="iddemande")
    private Demande demande;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idutilisateur",referencedColumnName="idutilisateur")
    private Utilisateur utilisateur;
	

public Intervention(String description, String date_deb, String etat) {
		
		this.description = description;
		this.date_deb = date_deb;
		this.etat = etat;
	}
	public Intervention() {
		
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	public Demande getDemande() {
		return demande;
	}
	public void setDemande(Demande demande) {
		this.demande = demande;
	}
	public Long getIdintervention() {
		return idintervention;
	}
	public void setIdintervention(Long idintervention) {
		this.idintervention = idintervention;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_deb() {
		return date_deb;
	}
	public void setDate_deb(String date_deb) {
		this.date_deb = date_deb;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public void assigndemande(Demande demande) {
		
		this.demande=demande;
	}

//	public void assignuser(Utilisateur utilisateur) {
//		// TODO Auto-generated method stub
//		this.utilisateur=utilisateur;
//	}
//    
    
    

}

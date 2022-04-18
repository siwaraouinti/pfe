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
public class Notif {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
    private Long idnotif ;
	
	@Column(length = 60)
	private String chaine ;
	@Column(length = 60)
	private String datee ;
	private String seen;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idsender",referencedColumnName="idutilisateur")
	 private Utilisateur utilisateur;
	
	
	public String getSeen() {
		return seen;
	}
	public void setSeen(String seen) {
		this.seen = seen;
	}
	
	public Long getIdnotif() {
		return idnotif;
	}
	public void setIdnotif(Long idnotif) {
		this.idnotif = idnotif;
	}
	
	public String getChaine() {
		return chaine;
	}
	public void setChaine(String chaine) {
		this.chaine = chaine;
	}
	public String getDatee() {
		return datee;
	}
	public void setDatee(String datee) {
		this.datee = datee;
	}
	
	
	public Notif(Long idnotif, String chaine, String datee, String seen) {
		super();
		this.idnotif = idnotif;
	
		this.chaine = chaine;
		this.datee = datee;
		this.seen = seen;
	}
	public Notif() {
		
	}
	public void assignsender(Utilisateur utilisateur) {
	this.utilisateur=utilisateur;
		
	}
	
}

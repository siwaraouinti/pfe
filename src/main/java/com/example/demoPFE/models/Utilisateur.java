package com.example.demoPFE.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Utilisateur {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
    private Long idutilisateur ;
    @Column(length = 60)
    private String nom;
    @Column(length = 60)
    private String prenom;
    @Column(length = 60)
    
    private String email;
	@Column(length = 60)
    private String mdp;
   
    
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="idrole",referencedColumnName="idrole")
 private Role role;
    
@JsonIgnore
@OneToMany(mappedBy="utilisateur")
private Set<Demande> demandes = new HashSet<>();

@JsonIgnore
@OneToMany(mappedBy="utilisateur")
private Set<Intervention> interventions = new HashSet<>();


@JsonIgnore
@OneToMany(mappedBy="utilisateur")
private Set<Notif> notifs = new HashSet<>();

public Utilisateur() {
		
	}
	public Utilisateur(String nom, String prenom, String email, String mdp) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
	}
	public Long getIdutilisateur() {
		return idutilisateur;
	}
	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	 public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public void assignrole(Role role) {
			// TODO Auto-generated method stub
		this.role=role;	
		}
		public Set<Demande> getDemandes() {
			return demandes;
		}
		public void setDemandes(Set<Demande> demandes) {
			this.demandes = demandes;
		}
		public Set<Intervention> getInterventions() {
			return interventions;
		}
		public void setInterventions(Set<Intervention> interventions) {
			this.interventions = interventions;
		}
}

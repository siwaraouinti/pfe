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
public class Role {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
    private Long idrole ;
    @Column(length = 60)
    private String designation;
    @JsonIgnore
    @OneToMany(mappedBy="role")
    private Set<Utilisateur> utilisateurs = new HashSet<>();
	
	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	 
	public Long getIdrole() {
		return idrole;
	}
	public void setIdrole(Long idrole) {
		this.idrole = idrole;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Role(String designation) {
		
		this.designation = designation;
	}
	public Role() {
		
	}

}

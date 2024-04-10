package com.lalmat.fia.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	private String pays;
	
	@OneToMany(cascade=CascadeType.DETACH)
	private Set<Pilote> pilotes = new HashSet<Pilote>();
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Set<Pilote> getPilotes() {
		return pilotes;
	}
	public void setPilotes(Set<Pilote> pilotes) {
		this.pilotes = pilotes;
	}
}

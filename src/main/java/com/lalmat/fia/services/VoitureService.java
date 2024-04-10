package com.lalmat.fia.services;

import java.util.List;

import com.lalmat.fia.models.Voiture;

public interface VoitureService {
	
	public List<Voiture> findAll();

	public Voiture findById(int id);

	public Voiture create(Voiture voiture);

	public Voiture update(int id, Voiture voiture);
	
	public void delete(int id);
	
}

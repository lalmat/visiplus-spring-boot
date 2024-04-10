package com.lalmat.fia.services;

import java.util.List;

import com.lalmat.fia.models.Pilote;

public interface PiloteService {
	public List<Pilote> findAll();

	public Pilote findById(int id);

	public Pilote create(Pilote pilote);

	public Pilote update(int id, Pilote pilote);

	public Pilote setVoiture(int id, int voitureId);
	
	public void delete(int id);
}

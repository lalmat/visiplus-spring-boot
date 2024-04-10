package com.lalmat.fia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalmat.fia.dao.PiloteRepository;
import com.lalmat.fia.exceptions.EntityNotFoundException;
import com.lalmat.fia.models.Pilote;
import com.lalmat.fia.models.Voiture;
import com.lalmat.fia.services.PiloteService;

@Service
public class PiloteServiceImpl implements PiloteService {

	@Autowired
	private PiloteRepository piloteRepository;
	
	@Autowired
	private VoitureServiceImpl voitureService;
	
	@Override
	public List<Pilote> findAll() {
		List<Pilote> dbPilotes = new ArrayList<Pilote>();
		piloteRepository.findAll().forEach(dbPilotes::add);
		return dbPilotes;
	}

	@Override
	public Pilote findById(int id) {
		Pilote dbPilotes = piloteRepository.findById(id).get();
		if (dbPilotes == null) {
			throw new EntityNotFoundException();
		}
		return dbPilotes;
	}

	@Override
	public Pilote create(Pilote pilote) {
		return piloteRepository.save(pilote);
	}

	@Override
	public Pilote update(int id, Pilote pilote) {
		Pilote dbPilote = this.findById(id);
		
		String newNom = pilote.getNom();
		if (newNom != null) dbPilote.setNom(newNom);
		
		Voiture newVoiture = pilote.getVoiture();
		if (newVoiture != null) dbPilote.setVoiture(newVoiture);
		
		return piloteRepository.save(dbPilote);
	}

	@Override
	public void delete(int id) {
		Pilote pilote = this.findById(id);
		Voiture voiture = pilote.getVoiture();
		if (voiture != null) {
			voiture.setPilote(null);
		}
		
		piloteRepository.delete(pilote);
	}

	@Override
	public Pilote setVoiture(int id, int voitureId) {
		Pilote dbPilote = this.findById(id);
		Voiture dbVoiture = voitureService.findById(voitureId);
		
		Pilote oldPilote = dbVoiture.getPilote();
		if (oldPilote != null) {
			oldPilote.setVoiture(null);
			piloteRepository.save(oldPilote);
		}
		
		dbPilote.setVoiture(dbVoiture);
		dbVoiture.setPilote(dbPilote);
		
		return piloteRepository.save(dbPilote);
	}
	
}

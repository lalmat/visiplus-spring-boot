package com.lalmat.fia.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalmat.fia.dao.VoitureRepository;
import com.lalmat.fia.exceptions.EntityNotFoundException;
import com.lalmat.fia.models.Voiture;
import com.lalmat.fia.services.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	private VoitureRepository voitureRepository;
	
	@Override
	public List<Voiture> findAll() {
		List<Voiture> voitures = new ArrayList<Voiture>();
		voitureRepository.findAll().forEach(voitures::add);
		return voitures;
	}

	@Override
	public Voiture findById(int id) {
		try {
			Voiture dbVoiture = voitureRepository.findById(id).get();
			if (dbVoiture == null) throw new EntityNotFoundException();
			return dbVoiture;
		}
		catch(Exception e) {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public Voiture create(Voiture voiture) {
		return voitureRepository.save(voiture);
	}

	@Override
	public Voiture update(int id, Voiture voiture) {
		Voiture dbVoiture = this.findById(id);
		
		String newNom = voiture.getNom();
		if (newNom != null) dbVoiture.setNom(newNom);

		int newVitesse = voiture.getVitesse();
		if (newVitesse > 0) dbVoiture.setVitesse(newVitesse);
		
		return voitureRepository.save(dbVoiture);
	}

	@Override
	public void delete(int id) {
		voitureRepository.delete(this.findById(id));
	}
}

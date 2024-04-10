package com.lalmat.fia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lalmat.fia.models.Voiture;
import com.lalmat.fia.services.VoitureService;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

	@Autowired
	private VoitureService voitureService;
	
	// List
	@GetMapping("")
	public List<Voiture> findAll() {
		return voitureService.findAll();
	}
	
	// Create
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Voiture create(@RequestBody Voiture voiture) {
		return voitureService.create(voiture);
	}
	
	// Read
	@GetMapping("/{id}") 
	@ResponseStatus(code=HttpStatus.OK)
	public Voiture findById(@PathVariable("id") int id) {
		return voitureService.findById(id);
	}
	
	// Update
	@PatchMapping("/{id}")
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Voiture update(@PathVariable("id") int id, @RequestBody Voiture voiture) {
		return voitureService.update(id, voiture);
	}
	
	// Delete
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void delete(@PathVariable("id") int id) {
		voitureService.delete(id);
	}

}

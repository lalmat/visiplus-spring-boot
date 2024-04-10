package com.lalmat.fia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lalmat.fia.models.Pilote;
import com.lalmat.fia.models.Voiture;
import com.lalmat.fia.services.PiloteService;

@RestController
@RequestMapping("/pilotes")
public class PiloteController {

	@Autowired
	private PiloteService piloteService;
	
	
	@GetMapping("")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Pilote> findAll() {
		return piloteService.findAll();
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Pilote create(@RequestBody Pilote pilote) {
		return piloteService.create(pilote);
	}
	
	@PatchMapping("/{piloteId}/voiture")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void setVoiture(@PathVariable("piloteId") int piloteId, @RequestBody Voiture voiture) {
		piloteService.setVoiture(piloteId, voiture.getId());
	}
	
	
	@DeleteMapping("/{piloteId}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void delete(@PathVariable("piloteId") int piloteId) {
		piloteService.delete(piloteId);
	}
	
}
	

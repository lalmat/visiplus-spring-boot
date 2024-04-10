package com.lalmat.fia.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalmat.fia.dao.CourseRepository;
import com.lalmat.fia.exceptions.EntityNotFoundException;
import com.lalmat.fia.models.Course;
import com.lalmat.fia.models.Pilote;
import com.lalmat.fia.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		List<Course> dbCourses = new ArrayList<Course>();
		courseRepository.findAll().forEach(dbCourses::add);
		return dbCourses;
	}

	@Override
	public Course findById(int id) {
		Course dbCourse = courseRepository.findById(id).get();
		if (dbCourse == null) {
			throw new EntityNotFoundException();
		}
		return dbCourse;
	}

	@Override
	public Course create(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course update(int id, Course course) {
		Course dbCourse = this.findById(id);
		
		String newNom = course.getNom();
		if (newNom != null) dbCourse.setNom(newNom);
		
		String newPays = course.getPays();
		if (newPays != null) dbCourse.setPays(newPays);
		
		return courseRepository.save(dbCourse);
	}

	@Override
	public void addPilote(int id, Pilote pilote) {
		Course dbCourse = this.findById(id);
	
		Set<Pilote> pilotes = dbCourse.getPilotes();
		pilotes.add(pilote);
		dbCourse.setPilotes(pilotes);
		
		courseRepository.save(dbCourse);
	}

	@Override
	public void delete(int id) {
		Course dbCourse = this.findById(id);
		courseRepository.delete(dbCourse);
	}

	@Override
	public String start(int id, int vitesse) {
		Set<Pilote> pilotes = this.findById(id).getPilotes();
		
		String message = "Resultat :\n";
		
		for (Pilote pilote : pilotes) {
			if (pilote.getVoiture() == null) continue;
			if (pilote.getVoiture().getVitesse() < vitesse) continue;
			
			message += "- Le pilote" + pilote.getNom() + "peut participer à la course avec sa voiture " + pilote.getVoiture().getNom()+"("+pilote.getVoiture().getVitesse()+" Km/h)\n"; 
		}

		return message;
	}

}

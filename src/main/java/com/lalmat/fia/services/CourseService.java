package com.lalmat.fia.services;

import java.util.List;

import com.lalmat.fia.models.Course;
import com.lalmat.fia.models.Pilote;

public interface CourseService {
	public List<Course> findAll();

	public Course findById(int id);

	public Course create(Course course);

	public Course update(int id, Course course);

	public void addPilote(int id, Pilote pilote);
	
	public void delete(int id);
	
	public String start(int id, int vitesse);
}

package com.lalmat.fia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lalmat.fia.models.Course;
import com.lalmat.fia.models.Pilote;
import com.lalmat.fia.services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("")
	@ResponseStatus(code=HttpStatus.OK)
	public List<Course> findAll() {
		return courseService.findAll();
	}
	
	@GetMapping("/{courseId}")
	@ResponseStatus(code=HttpStatus.OK)
	public Course findById(@PathVariable("courseId") int courseId) {
		return courseService.findById(courseId);
	}
	
	@PostMapping("")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Course create(@RequestBody Course course) {
		return courseService.create(course);
	}
	
	@PatchMapping("/{courseId}/pilote")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void create(@PathVariable("courseId") int courseId, @RequestBody Pilote pilote) {
		courseService.addPilote(courseId, pilote);
	}
	
	@GetMapping("/{courseId}/vitesse/{vitesse}/start")
	@ResponseStatus(code=HttpStatus.OK)
	public String start(@PathVariable("courseId") int courseId, @PathVariable("vitesse") int vitesse) {
		return courseService.start(courseId, vitesse);
	}
}

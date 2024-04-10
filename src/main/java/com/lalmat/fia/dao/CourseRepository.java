package com.lalmat.fia.dao;

import org.springframework.data.repository.CrudRepository;

import com.lalmat.fia.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}

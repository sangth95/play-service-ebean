package services;

import java.util.List;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.node.ArrayNode;

import models.*;

@Singleton
public final class ServiceFake implements MyService{

	//Course CRUD
	public Course createCourse(Course course) {
		return null;
	}

	public Course readCourse(Integer id) {
		return null;
	}

	public Course updateCourse(Course course) {
		return null;
	}

	public Boolean deleteProject(Integer id) {
		return null;
	}

	public List<Course> allCourse() {
		return null;
	}
	
	
	public ArrayNode allStudentInCourse(Integer id) {
		return null;
	}

	public Integer countCourse() {
		return null;
	}


	//Student CRUD
	public Student createStudent(Student student) {
		return null;
	}

	public Student readStudent(Integer id) {
		return null;
	}

	public Student updateStudent(Student student) {
		return null;
	}
	public Boolean deleteStudent(Integer id) {
		return null;
	}

	public List<Student> allStudent() {
		return null;
	}

	public Integer countStudent() {
		return null;
	}
}

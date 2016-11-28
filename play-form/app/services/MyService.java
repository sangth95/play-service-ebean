package services;

import java.util.List;

import models.*;

public interface MyService {
	
	
	//Course CRUD
	Course createCourse(Course course);

	Course readCourse(Integer id);
	
	Course updateCourse(Course course);
	
	Boolean deleteProject(Integer id);
	
	List<Course> allCourse();
	
	List<Student> allStudentInCourse(Integer id);
	
	Integer countCourse();
	
	
	//Student CRUD
	Student createStudent(Student student);
	
	Student readStudent(Integer id);
	
	Student updateStudent(Student student);
	
	Boolean deleteStudent(Integer id);
	
	List<Student> allStudent();
	
	Integer countStudent();
}

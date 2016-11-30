package services;

import java.util.List;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Course;
import models.Student;



@Singleton
public class ServiceImpl implements MyService{

	//Course CRUD
	public Course createCourse(Course course) {
		course.save();
		return course;
	}

	public Course readCourse(Integer id) {
		return Course.find.byId(id);
	}

	public Course updateCourse(Course course) {
		course.update();
		return course;
	}

	public Boolean deleteProject(Integer id) {
		Course course = Course.find.byId(id);
		if (null != course) {
			return course.delete();
		} else {
			return false;
		}
	}

	public List<Course> allCourse() {
		return Course.find.all();
	}
	
	public ArrayNode allStudentInCourse(Integer id) {
		List<Student> studentList = Student.find.select("*").where().eq("class_id", id).findList();
		//json object
		JsonNodeFactory nodeFactory = JsonNodeFactory.instance;
		
		ArrayNode arrayNode = nodeFactory.arrayNode();
		
		for (Student student: studentList) {
			ObjectNode nodeStudent = nodeFactory.objectNode();
			
			nodeStudent.put("id", student.getId());
			nodeStudent.put("name", student.getName());
			nodeStudent.put("course_name", student.getCourse().getName());
			
			arrayNode.add(nodeStudent);
		}
		return arrayNode;
	}

	public Integer countCourse() {
		return Integer.valueOf(Course.find.findRowCount());
	}


	//Student CRUD
	public Student createStudent(Student student) {
		student.save();
		return student;
	}

	public Student readStudent(Integer id) {
		Student student = Student.find.byId(id);
		return student;
	}

	public Student updateStudent(Student student) {
		student.update();
		return student;
	}
	public Boolean deleteStudent(Integer id) {
		Student student = Student.find.byId(id);
		if(null != student) {
			return student.delete();
		} else {
			return false;
		}
	}

	public List<Student> allStudent() {
		return Student.find.all();
	}

	public Integer countStudent() {
		return Integer.valueOf(Student.find.findRowCount());
	}
}

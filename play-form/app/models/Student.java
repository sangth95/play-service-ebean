package models;

import javax.persistence.*;
import javax.validation.Constraint;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import play.data.validation.Constraints;

@Entity
public class Student extends Model{
	
	@Id 
	@Column(name = "id")
	private Integer id;
	
	@Constraints.Required
	@Column(name = "name")
	private String name;

	@Constraints.Required
	@Column(name = "class_id")
	private Integer class_id;
	
	
	public Student() {
		super();
	}

	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	 
	@ManyToOne
	@JoinColumn(name="class_id", referencedColumnName="id")
	@JsonManagedReference
	private Course course;
	



	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


	public static Find<Integer, Student> find = new Find<Integer, Student>(){};
}

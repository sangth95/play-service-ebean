package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import play.data.validation.*;

@Entity
public class Course extends Model{
	
	@Id
	@Column(name = "id")
	private Integer id;

	@Constraints.Required
	@Column(name = "name")
	private String name;

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

	public static Find<Integer, Course> find = new Find<Integer, Course>(){};
	
	

	@OneToMany(cascade= CascadeType.ALL, mappedBy = "course")
	@JsonBackReference
	public static List<Student> students = new ArrayList<Student>();
}

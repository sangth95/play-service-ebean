package controllers;

import models.Student;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.util.parsing.json.JSON;

public class StudentController extends Controller {
	
	public Result index() {
		return ok("ok");
	}
	
	public Result getAllStudent() {
		return ok(Json.toJson(Student.find.all()));
	}
	
	public Result getStudent(Integer id) {
		return ok(Json.toJson(Student.find.byId(id)));
	}
	
	public Result getStudentCourse(Integer id) {
		Student student = Student.find.byId(id); 
		return ok(Json.toJson(student.getCourse()));
	}
}

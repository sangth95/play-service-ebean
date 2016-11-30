package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.avaje.ebean.annotation.Transactional;

import controllers.responses.ErrorResponse;
import controllers.responses.SuccessResponse;
import models.Student;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.util.parsing.json.JSON;
import services.MyService;
import services.ServiceFactory;

@Singleton
public class StudentController extends Controller {
	
	//service
	private final MyService myService;
	
	private final FormFactory formFactory;
	
	@Inject
	public StudentController(FormFactory formFactory, ServiceFactory serviceFactory) {
		this.formFactory = formFactory;
		this.myService = serviceFactory.getService();
	}
	
	public Result index() {
		return ok("ok");
	}
	
	@Transactional(readOnly = true)
	public Result getAllStudent() {
		List<Student> allStudents = myService.allStudent(); 
		return ok(Json.toJson(allStudents));
	}
	
	@Transactional(readOnly = true)
	public Result getStudent(Integer id) {
		Student student = myService.readStudent(id);
		if( null == student) {
			ErrorResponse response = new ErrorResponse(2,
					"Not found student with id " + id);
			return notFound(Json.toJson(response));
		} else {
			SuccessResponse response = new SuccessResponse(student);
			return ok(Json.toJson(response));
		}
	}
	
	public Result getStudentCourse(Integer id) {
		Student student = myService.readStudent(id);
		if( null == student) {
			ErrorResponse response = new ErrorResponse(2,
					"Not found student with id " + id);
			return notFound(Json.toJson(response));
		} else {
			SuccessResponse response = new SuccessResponse(student.getCourse());
			return ok(Json.toJson(response));
		}
	}
}

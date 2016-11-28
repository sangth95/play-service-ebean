package controllers;


import views.html.*;
import play.data.*;
import static play.data.Form.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.annotation.Transactional;

import controllers.responses.ErrorResponse;
import controllers.responses.SuccessResponse;
import models.*;
import play.api.mvc.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.MyService;
import services.ServiceFactory;

@Singleton
public class CourseController extends Controller{
	
	
	//Service 
	private final MyService myService;
	
	private final FormFactory formFactory;
	

	@Inject
	public CourseController(FormFactory formFactory, ServiceFactory serviceFactory) {
		this.formFactory = formFactory;
		this.myService = serviceFactory.getService();
	}


	
	public Result index(){
		return ok("ok");
	}

	@Transactional(readOnly = true)
	public Result read(Integer id) {
		Course course = myService.readCourse(id);
		if(null == course) {
			ErrorResponse response = new ErrorResponse(2,
					"Not found course with id " + id);
			return notFound(Json.toJson(response));
		} else {
			SuccessResponse response = new SuccessResponse(course);
			return ok(Json.toJson(response));
		}	
	}
	
	@Transactional(readOnly = true)
	public Result getAllCourses() {
		List<Course> allCourses = myService.allCourse();
		return ok(Json.toJson(allCourses));
	}
	
	
	public Result getAllStudentOfCourse(Integer id) {
		List<Student> studentList = myService.allStudentInCourse(id);
		return ok(Json.toJson(studentList));	
	}
	
	public Result createNewCourse() {
		return ok("ok");
	}
	

}

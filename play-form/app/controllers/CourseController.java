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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
		ArrayNode studentArrayNode = myService.allStudentInCourse(id);
		return ok(studentArrayNode);	
	}
	
	public Result createNewCourse() {
		Form<Course> courseForm = formFactory.form(Course.class).bindFromRequest();
		if (courseForm.hasErrors()) {
			ErrorResponse response = new ErrorResponse(1, courseForm.errorsAsJson().toString());
			return badRequest(Json.toJson(response));
		} else {
			Course course = courseForm.get();
			Course newCourse = myService.createCourse(course);
			SuccessResponse response = new SuccessResponse(newCourse);
			return ok(Json.toJson(response));
		}
	}
	
	public Result updateCourse() {
		Form<Course> courseForm = formFactory.form(Course.class).bindFromRequest();
		if(courseForm.hasErrors()) {
			ErrorResponse response = new ErrorResponse(1, courseForm.errorsAsJson().toString());
			return badRequest(Json.toJson(response));
		} else {
			Course course = courseForm.get();
			Course newCourse = myService.updateCourse(course);
			SuccessResponse response = new SuccessResponse(newCourse);
			return ok(Json.toJson(response));
		}
	}
	
	
	public Result deleteCourse(Integer id) {
		if (myService.deleteProject(id)) {
			ObjectNode result = Json.newObject();
			result.put("message", "Deleted course with id " + id);
			SuccessResponse response = new SuccessResponse(result);
			return ok(Json.toJson(response));
		} else {
			ErrorResponse response = new ErrorResponse(1, 
					"Not found course with id " + id);
			return notFound(Json.toJson(response));
		}
	}

}

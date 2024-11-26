package com.ntt.Catalogue.controllers;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin("http://localhost:4200")
@RequestMapping("api")
@RestController
public class RestApiController {
	@GetMapping(path = "/courses",produces = "application/json")
	   public @ResponseBody List<Course> getAll(){
	       List<Course> data  = new ArrayList<>();
	       data.add(new Course("test",10));
	       data.add(new Course("test1",10));
	       data.add(new Course("test2",10));
	       data.add(new Course("test3",10));
	       data.add(new Course("test4",10));
	       data.add(new Course("test5",10));
	       return data;
	   }
	
   class Course {
	   private String title;
	   private Integer nb_student;
       public Course(String string, int i) {
		// TODO Auto-generated constructor stub 
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getNb_student() {
		return nb_student;
	}
	public void setNb_student(Integer nb_student) {
		this.nb_student = nb_student;
	}
	
   }
   
}
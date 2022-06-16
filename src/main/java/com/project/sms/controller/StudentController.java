package com.project.sms.controller;

import java.util.List;
import java.util.Optional;

import com.project.sms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.sms.model.Student;
import com.project.sms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
		StudentService studentService;
	@Autowired
	private AuthService authService;


	/*
	* url http://localhost/studentList
	* method GET
	* desc shows all of student information
	* */

	@RequestMapping("/list")
	public String getAll(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students", students);
		return "list";
	}
	/*
	 * url http://localhost/studentList/save
	 * method	GET
	 * desc Show the student create form.
	 * */
	@RequestMapping(value = "/save")
	public String saveStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "save";
	}
	/*
	 * url http://localhost/studentList/save
	 * method	POST
	 * desc Save the student to database
	 * */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(Student student) {
		authService.saveUser(student);
		return "redirect:/student/list";
	}
}

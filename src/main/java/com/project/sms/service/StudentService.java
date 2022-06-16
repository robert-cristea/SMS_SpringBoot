package com.project.sms.service;

import java.util.List;
import java.util.Optional;

import com.project.sms.model.Student;

public interface StudentService {

	List<Student> findAll();
	void saveOrUpdateStudent(Student student);
	Student findByByEmail(String email);
}

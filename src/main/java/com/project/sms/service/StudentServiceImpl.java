package com.project.sms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.model.Student;
import com.project.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService  {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public void saveOrUpdateStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Student findByByEmail(String email){ return studentRepository.findByEmail(email);}

}

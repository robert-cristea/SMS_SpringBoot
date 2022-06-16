package com.project.sms.controller;

import com.project.sms.model.Student;
import com.project.sms.payload.LoginRequest;
import com.project.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value="/login")
    public String goLogin() {
        return "auth/login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String doLogin(LoginRequest loginRequest) {

        Student student = studentService.findByByEmail(loginRequest.getEmail());
        System.out.println(student);

        if(student != null) {
            if(student.getPassword().matches(loginRequest.getPassword())) {
                System.out.println("hello");
                return "redirect:/home";
            }
        }
        return "redirect:/login";
    }
}

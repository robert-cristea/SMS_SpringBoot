package com.project.sms.controller;

import com.project.sms.model.Student;
import com.project.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/home")
    public String Home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Student user = studentService.findByByEmail(auth.getName());
        model.addAttribute("currentUser", user);
        return "home";
    }
}

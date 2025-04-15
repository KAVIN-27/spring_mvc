package com.springmvc.thymeleaf.controller;

import com.springmvc.thymeleaf.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentFrom")
    public String showForm(Model model){

        //create a new Student object
        Student theStudent = new Student();

        //add student object as a model attribute
        model.addAttribute("student",theStudent);

        return "student-form";
    }

    @PostMapping(path = "processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.printf("theStudent "+theStudent.getFirstName()+" "+ theStudent.getLastName());

        return "student-confirmation";
    }

}

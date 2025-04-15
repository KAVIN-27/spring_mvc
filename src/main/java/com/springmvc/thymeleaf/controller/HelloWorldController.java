package com.springmvc.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    @GetMapping(path = "/showform")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping(path = "/processform")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping(path = "/processformsecondversion")
    public String processFormSecondVersion(HttpServletRequest request, Model model){

        //read the request paramter from the HTML form
        String theName = request.getParameter("studentName");

        //convert the data to all uppercase

        theName = theName.toUpperCase();

        //create the message

        String result = "Hola!" + theName;

        //add the result to the model

        model.addAttribute("message",result);

        return "helloworld";
    }

    @PostMapping(path = "/processformsthirdversion")
    public String processFormThirdVersion(@RequestParam("studentName") String theName,Model model){
        theName = theName.toUpperCase();

        String result = "Hola! "   + theName;

        model.addAttribute("message",result);

        return "helloworld";
    }

}

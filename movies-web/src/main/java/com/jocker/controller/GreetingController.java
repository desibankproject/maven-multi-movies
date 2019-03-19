package com.jocker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller is mandatory here
@Controller
public class GreetingController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
	
	public GreetingController(){
		System.out.println("GreetingControllerGreetingControllerGreetingControllerGreetingControllerGreetingControllerGreetingController");
	}
	
	//  	<form action="greet" method="get">
	//greet
	@GetMapping("welcome")
	public String greetMe(HttpServletRequest req){
		String gname=req.getParameter("gname");
		gname="Hello Mr. "+gname+" , how are you doing???";
		req.setAttribute("message", gname);
		return "greet"; //no need to write extension
	}
	
	@PostMapping("studentRegistration")
	public String registeStudent(HttpServletRequest req,Model model){
		String name=req.getParameter("name");
		String gender=req.getParameter("gender");
		String school=req.getParameter("school");
		String fname=req.getParameter("fname");
		Student student=new Student(name,gender,school,fname);
		System.out.println(student);
		//
		
		//model is used to carry data from controller to jsp
		//it is similar to req.setAttribute("student", student);
		model.addAttribute("student", student);
		return "success"; //no need to write extension
	}
	

}

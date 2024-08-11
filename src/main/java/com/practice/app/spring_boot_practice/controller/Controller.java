package com.practice.app.spring_boot_practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
	@RequestMapping(value = "/hello")
	public String helloWorld() 
	{
		return "APP IS WORKING";
		
	}

}

package com.hunza.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

//	@RequestMapping(method = RequestMethod.GET, value = "/")
//	public String index(){
//		return "Test for Hunza Consulting..";
//	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/swagger")
	public String sayHello() {
		return "Swagger Hello World";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
	public String saySwagger() {
		return "Swagger Hello World";
	}
}
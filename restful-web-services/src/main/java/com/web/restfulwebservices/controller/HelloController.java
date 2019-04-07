package com.web.restfulwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.restfulwebservices.PropertyConfig;
import com.web.restfulwebservices.model.Merchant;
import com.web.restfulwebservices.services.HelloService;

@RestController
@RequestMapping("/mchnt")
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	@Autowired
	PropertyConfig propertyConfig;
	
	@GetMapping("/ping")
	public String ping()
	{
		System.out.println("config "+propertyConfig);
		System.out.println("ping method changed");
//		comment added
		return "ping called in halloController";
		
	}
	
	@GetMapping("/info")
	public ResponseEntity<List<Merchant>> display()
	{
		System.out.println("display method changed");
		List<Merchant> listOfMchnts = helloService.display();
		return new ResponseEntity<List<Merchant>>(listOfMchnts,HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<Merchant> mchntList()
	{
		
		Merchant m = new Merchant();
		m.setMchntId("8963");
		m.setMchntName("Pentaloon");
		m.setMchntCity("Kolkata");
		return new ResponseEntity<Merchant>(m,HttpStatus.OK);
	}

}

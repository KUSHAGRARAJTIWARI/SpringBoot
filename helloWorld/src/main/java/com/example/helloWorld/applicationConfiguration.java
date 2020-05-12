package com.example.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class applicationConfiguration {
	

	@Autowired
	private service ser;
	
	@RequestMapping("/hello")
	public String show() {
		return ser.sendMessage();
	}
	
	
}

@Component
class service{
	public String sendMessage() {
		return "Hello World";
	}
}

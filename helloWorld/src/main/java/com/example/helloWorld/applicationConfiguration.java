package com.example.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Control {
	

	@Autowired
	private Message message;
	
	@RequestMapping("/hello")
	public String show() {
		return message.showMessage();
	}
	
	
}

@Component
class Message{
	public String showMessage() {
		return "Hello! World";
	}
}

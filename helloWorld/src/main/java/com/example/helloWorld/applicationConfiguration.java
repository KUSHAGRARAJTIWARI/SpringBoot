package com.example.helloWorld;
import org.springframework.web.bind.annotation.*;

@RestController
public class applicationConfiguration {
	

	@RequestMapping("/hello")
	public String hello() {
		return "Hello! World, I am Kushagra.";
	}
	
}

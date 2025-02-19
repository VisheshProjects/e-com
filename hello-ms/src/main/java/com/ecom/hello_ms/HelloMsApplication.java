package com.ecom.hello_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloMsApplication.class, args);
	}

	@GetMapping("/hello")
	public String getHello(@RequestParam(value="name" , defaultValue = "world") String name){
			return String.format("Hello %s!!" , name);
	}

}

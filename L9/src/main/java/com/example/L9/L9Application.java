package com.example.L9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class L9Application {

	public static void main(String[] args) {
		SpringApplication.run(L9Application.class, args);
	}
	@GetMapping
	public String bobo() {
		return "bobo";
	}
}

package com.example.L9.basket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IgraciKontroler {

	public static void main(String[] args) {
		SpringApplication.run(IgraciKontroler.class, args);
	}
	
	private AfrickaReprezentacija ar;
	
	public IgraciKontroler(){
		this.ar = new AfrickaReprezentacija();
	}
	
	@GetMapping("/players/stats/{id}")
	@ResponseBody
	public String getIgrac(@PathVariable String id) {
		return ar.vratiIgraca(id).toString();
	}
}

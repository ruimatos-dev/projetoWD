package com.wd.projeto01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Projeto01Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto01Application.class, args);
	}
}

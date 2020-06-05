package com.backend.gen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenBackEndApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GenBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
	}	
}

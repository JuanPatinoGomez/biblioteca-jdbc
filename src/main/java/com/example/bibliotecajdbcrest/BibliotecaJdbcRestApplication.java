package com.example.bibliotecajdbcrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaJdbcRestApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(BibliotecaJdbcRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaJdbcRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}

	

}

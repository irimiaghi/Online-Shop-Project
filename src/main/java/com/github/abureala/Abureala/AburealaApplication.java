package com.github.abureala.Abureala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.SchemaOutputResolver;

@SpringBootApplication
public class AburealaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AburealaApplication.class, args);
		System.out.println("Hello World!");
	}
}

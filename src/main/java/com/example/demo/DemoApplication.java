package com.example.demo;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CarRepository carRepository;
	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	//this method will run everytime we run project
	public void run(String... args){

	}

}

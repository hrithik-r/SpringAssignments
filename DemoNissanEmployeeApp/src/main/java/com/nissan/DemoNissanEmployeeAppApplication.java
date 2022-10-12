package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoNissanEmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoNissanEmployeeAppApplication.class, args);
		System.out.println("Nissan");
	}

}

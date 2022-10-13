package com.nissan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJwtAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJwtAppApplication.class, args);
		System.out.println("Spring Boot Maven JWT");
	}

}

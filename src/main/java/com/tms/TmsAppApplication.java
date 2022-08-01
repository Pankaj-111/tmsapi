package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tms")
public class TmsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsAppApplication.class, args);
	}

}

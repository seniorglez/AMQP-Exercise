package com.seniorglez.server;

import com.seniorglez.server.application.annotation.Injectable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		basePackages = "com.seniorglez.server",
		includeFilters = @ComponentScan.Filter(
				type = FilterType.ANNOTATION,
				classes = Injectable.class
		)
)
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

}

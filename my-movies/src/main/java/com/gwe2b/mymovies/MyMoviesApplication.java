package com.gwe2b.mymovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MyMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyMoviesApplication.class, args);
	}

}

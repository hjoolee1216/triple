package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.demo.config.DefaultViewConfig;
import com.example.demo.config.RepositoryConfig;
import com.example.demo.config.SwaggerConfig;

@SpringBootApplication
@Import({RepositoryConfig.class, SwaggerConfig.class, DefaultViewConfig.class})
public class TripleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripleApplication.class, args);
	}

}


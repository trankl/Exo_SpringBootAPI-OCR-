package com.example.demoAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@Data
@SpringBootApplication
public class DemoApiApplication implements CommandLineRunner {


	@Autowired
    private CustomProperties properties;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        System.out.println(properties.getApiUrl());
    
    }
}

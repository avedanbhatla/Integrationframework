package com.lzb.camel.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class CamelApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CamelApplication.class, args);
		
	}
	


}

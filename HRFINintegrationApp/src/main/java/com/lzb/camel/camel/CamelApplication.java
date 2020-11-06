package com.lzb.camel.camel;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages ={"com.lzb.camel.camel"})
@SpringBootApplication

public class CamelApplication {
	
	 
	public static void main(String[] args) {
		SpringApplication.run(CamelApplication.class, args);
		
		
	}
	


}

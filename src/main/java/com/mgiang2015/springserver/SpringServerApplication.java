package com.mgiang2015.springserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mgiang2015.springserver") // Tell SpringBoot to find Entity classes
@EnableAutoConfiguration // out of the box support for a lot of configuration! No need to config for things like databse support, schema creation etc...
public class SpringServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServerApplication.class, args);
	}

}

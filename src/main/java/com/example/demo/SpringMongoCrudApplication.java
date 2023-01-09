package com.example.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo")
@Log4j2
public class SpringMongoCrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =
			SpringApplication.run(SpringMongoCrudApplication.class, args);
		
		var mongoDbHost = ctx.getEnvironment().getProperty("spring.data.mongodb.host");
		var mongoDbPort = ctx.getEnvironment().getProperty("spring.data.mongodb.port");
		log.info("Connected to MongoDb: " + mongoDbHost + ":" + mongoDbPort);
	}

}

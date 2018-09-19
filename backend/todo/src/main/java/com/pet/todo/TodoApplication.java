package com.pet.todo;

import com.pet.todo.config.AppConfiguration;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfiguration.class)
public class TodoApplication {

	public static void main(String[] args) {
		 SpringApplication.run(TodoApplication.class, args);
	}

	@Bean
	public PhysicalNamingStrategy physicalNamingStrategy() {
		return new PhysicalNamingStrategyStandardImpl();
	}

}

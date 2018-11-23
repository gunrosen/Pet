package com.pet.todo;


import com.pet.todo.security.SecurityFilter;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.pet.todo.config","com.pet.todo.security"})
public class TodoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		 SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TodoApplication.class);
	}

	@Bean
	public PhysicalNamingStrategy physicalNamingStrategy() {
		return new PhysicalNamingStrategyStandardImpl();
	}

	@Bean
	public FilterRegistrationBean securityFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new SecurityFilter());
		registrationBean.addUrlPatterns("/*");
		return  registrationBean;
	}
}

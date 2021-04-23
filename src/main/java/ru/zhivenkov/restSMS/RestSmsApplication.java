package ru.zhivenkov.restSMS;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@SpringBootApplication
public class RestSmsApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(RestSmsApplication.class, args);
		System.out.println("Show beans provides by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		Arrays.stream(beanNames).forEach(x -> System.out.println(x));


	}

}

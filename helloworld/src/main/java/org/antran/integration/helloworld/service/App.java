package org.antran.integration.helloworld.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		System.out.println(context);
		GreeterService greeterService = context.getBean("greeterServiceImpl",
				GreeterService.class);

		greeterService.greet("Baby");
		context.close();
	}

}

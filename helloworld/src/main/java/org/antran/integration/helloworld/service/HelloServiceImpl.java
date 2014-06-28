package org.antran.integration.helloworld.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	public void hello(String name) {
		System.out.println("Hello " + name);
	}

	public String getHelloMessage(String name) {
		return "Hello, " + name;
	}

}

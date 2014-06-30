package org.antran.integration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	public void hello(String name) {
		System.out.println("Hello " + name);
	}
}

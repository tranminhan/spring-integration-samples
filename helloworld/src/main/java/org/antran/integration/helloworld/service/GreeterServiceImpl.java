package org.antran.integration.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class GreeterServiceImpl implements GreeterService {

	@Autowired
	MessageChannel helloWorldChannel;

	public void greet(String name) {
		helloWorldChannel.send(MessageBuilder.withPayload(name).build());
	}

	@Autowired
	HelloService helloWorldGateway;

	public void greet2(String name) {
		System.out.println(helloWorldGateway.getHelloMessage(name));
	}

}

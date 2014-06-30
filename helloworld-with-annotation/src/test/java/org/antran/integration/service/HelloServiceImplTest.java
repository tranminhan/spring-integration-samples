package org.antran.integration.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class HelloServiceImplTest {

	@Autowired
	ApplicationContext context;

	@Autowired
	MessageChannel requestChannel;

	@Test
	public void test() {
		assertNotNull(context);
		assertNotNull(requestChannel);

		Message<String> message = MessageBuilder.withPayload("Jim").build();
		requestChannel.send(message);

	}

}

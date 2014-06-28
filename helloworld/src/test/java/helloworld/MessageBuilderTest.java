package helloworld;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.util.ReflectionTestUtils;

public class MessageBuilderTest {

	@Test
	public void shouldBuildMessages() {
		Message<String> aMessage = MessageBuilder.withPayload("Payload")
				.setHeader("header1", "header 1 value").build();
		System.out.println(aMessage);

		assertNotNull(aMessage);
		assertNotNull(aMessage.getHeaders().get("id"));
		assertNotNull(aMessage.getHeaders().get("timestamp"));
		assertNotNull(aMessage.getHeaders().get("header1"));

		Message<String> anotherMessage = MessageBuilder.fromMessage(aMessage)
				.setHeaderIfAbsent("header1", "another value")
				.setHeader("header2", "header 2 value").build();
		System.out.println(anotherMessage);

		assertNotNull(anotherMessage.getHeaders().get("id"));
	}

}

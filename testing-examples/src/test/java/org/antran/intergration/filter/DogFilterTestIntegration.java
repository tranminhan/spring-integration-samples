package org.antran.intergration.filter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DogFilterTestIntegration
{
    @Autowired
    MessageChannel inputChannel1;
    
    @Autowired
    PollableChannel testChannel;
    
    @Autowired
    PollableChannel discardChannel;
    
    @Test
    public void shouldFilterAndPassMessageToOutput()
    {
        // when
        Message<String> message = MessageBuilder.withPayload("ANGRY DOG").build();
        inputChannel1.send(message);
        
        // then
        Message<?> receivedMessage = testChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("ANGRY DOG", receivedMessage.getPayload());
        
        // send again
        message = MessageBuilder.withPayload("CUTE CAT").build();
        inputChannel1.send(message);
        
        // then
        receivedMessage = testChannel.receive(0);
        assertNull(receivedMessage);
    }
    
    @Test
    public void shouldReceiveDiscardedMessage()
    {
        // when
        Message<String> message = MessageBuilder.withPayload("SMART CAT").build();
        inputChannel1.send(message);
        
        // then
        Message<?> receivedMessage = testChannel.receive(0);
        assertNull(receivedMessage);
        
        // then
        Message<String> discardedMessage = (Message<String>) discardChannel.receive(0);
        assertNotNull(discardedMessage);
        assertEquals("SMART CAT", discardedMessage.getPayload());
    }
}

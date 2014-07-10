package org.antran.intergration.aggragator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CommaAggregatorTestIntegration
{
    @Autowired
    MessageChannel inputChannel;
    
    @Autowired
    PollableChannel testChannel;
    
    @Test
    public void shouldAggregateMessage()
    {
        Message<String> message = MessageBuilder.withPayload("a,b").build();
        
        inputChannel.send(message);
        Message<?> receivedMessage = testChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("A,B", receivedMessage.getPayload());
        
        receivedMessage = testChannel.receive(0);
        assertNull(receivedMessage);
    }
    
}

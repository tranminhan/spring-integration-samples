package org.antran.intergration.splitter;

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
public class CommaSplitterTestIntegration
{
    @Autowired
    MessageChannel inputChannel;
    
    @Autowired
    PollableChannel testChannel;
    
    @Test
    public void shouldProduceOneMessage()
    {
        Message<String> message = MessageBuilder.withPayload("a").build();
        inputChannel.send(message);
        
        Message<String> receivedMessage = (Message<String>) testChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("a", receivedMessage.getPayload());
    }
    
    @Test
    public void shouldProduceTwoMessages()
    {
        Message<String> message = MessageBuilder.withPayload("a,b").build();
        inputChannel.send(message);
        
        Message<String> receivedMessage = (Message<String>) testChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("a", receivedMessage.getPayload());
        
        receivedMessage = (Message<String>) testChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("b", receivedMessage.getPayload());
    }
    
    @Test
    public void shouldProduceZeroMessage()
    {
        Message<String> message = MessageBuilder.withPayload(",,,").build();
        inputChannel.send(message);
        
        Message<String> receivedMessage = (Message<String>) testChannel.receive(0);
        assertNull(receivedMessage);        
    }
}

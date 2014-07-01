package org.antran.intergration.router;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PetRouterTestIntegration
{
    @Autowired
    MessageChannel inputChannel;
    
    @Autowired
    PollableChannel dogChannel;
    
    @Autowired
    PollableChannel catChannel;
    
    @Autowired
    PollableChannel theRestChannel;
    
    @Test
    public void shouldForwardMessageToDog()
    {
        Message<String> message = MessageBuilder.withPayload("dog").build();
        
        // when
        inputChannel.send(message);
        
        // then
        Message<String> receivedMessage = (Message<String>) dogChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("dog", receivedMessage.getPayload());
        
        receivedMessage = (Message<String>) catChannel.receive(0);
        assertNull(receivedMessage);
        
        receivedMessage = (Message<String>) theRestChannel.receive(0);
        assertNull(receivedMessage);
    }
    
    @Test
    public void shouldForwardMessageToCat()
    {
        Message<String> message = MessageBuilder.withPayload("cat").build();
        
        // when
        inputChannel.send(message);
        
        // then
        Message<String> receivedMessage = (Message<String>) catChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("cat", receivedMessage.getPayload());
        
        receivedMessage = (Message<String>) dogChannel.receive(0);
        assertNull(receivedMessage);
        
        receivedMessage = (Message<String>) theRestChannel.receive(0);
        assertNull(receivedMessage);
    }
    
    @Test
    public void shouldForwardMessageToTheRest()
    {
        Message<String> message = MessageBuilder.withPayload("human").build();
        
        // when
        inputChannel.send(message);
        
        // then
        Message<String> receivedMessage = (Message<String>) theRestChannel.receive(0);
        assertNotNull(receivedMessage);
        assertEquals("human", receivedMessage.getPayload());
        
        receivedMessage = (Message<String>) dogChannel.receive(0);
        assertNull(receivedMessage);
        
        receivedMessage = (Message<String>) catChannel.receive(0);
        assertNull(receivedMessage);
    }
}

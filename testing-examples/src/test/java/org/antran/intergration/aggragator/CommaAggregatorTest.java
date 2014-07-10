package org.antran.intergration.aggragator;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class CommaAggregatorTest
{
    
    @Test
    public void shouldAggrateString()
    {
        CommaAggregator aggregator = new CommaAggregator();
        
        String result = aggregator.aggregate(Arrays.asList("a", "b"));
        assertNotNull(result);
        assertEquals("a,b", result);
        
        result = aggregator.aggregate(Arrays.asList("a"));
        assertNotNull(result);
        assertEquals("a", result);
        
        result = aggregator.aggregate(Arrays.asList(""));
        assertNotNull(result);
        assertEquals("", result);
        
        result = aggregator.aggregate(Arrays.asList((String) null));
        assertNotNull(result);
        assertEquals("", result);
    }
    
}

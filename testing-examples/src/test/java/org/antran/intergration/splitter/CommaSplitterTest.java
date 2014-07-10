package org.antran.intergration.splitter;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CommaSplitterTest
{
    
    @Test
    public void shouldSplitAndTrim()
    {
        CommaSplitter splitter = new CommaSplitter();
        
        List<String> result = splitter.split("1, 2 , 3");
        assertEquals(3, result.size());
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
        
        result = splitter.split("1,, 2");
        assertEquals(2, result.size());
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));

        result = splitter.split(",,  ,");
        assertEquals(0, result.size());       
        
    }
     
}

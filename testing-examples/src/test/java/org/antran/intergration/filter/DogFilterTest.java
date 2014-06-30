package org.antran.intergration.filter;

import static org.junit.Assert.*;

import org.junit.Test;

public class DogFilterTest
{
    
    @Test
    public void shouldFilterDogOnly()
    {
        assertTrue(new DogFilter().filter("dog"));
        assertTrue(new DogFilter().filter("doG"));
        
        assertFalse(new DogFilter().filter("cat"));
        assertFalse(new DogFilter().filter("bird"));
    }
    
}

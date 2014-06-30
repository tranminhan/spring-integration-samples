package org.antran.intergration.filter;

import org.springframework.integration.annotation.Filter;

public class DogFilter
{
    
    @Filter
    public boolean filter(String pet)
    {
        return (pet != null) && pet.toUpperCase().contains("DOG");
    }
}

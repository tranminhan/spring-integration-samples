package org.antran.intergration.router;

import org.springframework.integration.annotation.Router;

public class PetRouter
{
    @Router
    public String route(String input)
    {
        if (input.toLowerCase().contains("dog"))
        {
            return "dogChannel";
        }
        else if (input.toLowerCase().contains("cat"))
        {
            return "catChannel";
        }
        return "theRestChannel";
    }
}

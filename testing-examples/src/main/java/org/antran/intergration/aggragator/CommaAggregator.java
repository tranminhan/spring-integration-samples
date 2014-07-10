package org.antran.intergration.aggragator;

import java.util.List;

import org.springframework.integration.annotation.Aggregator;

public class CommaAggregator
{
    @Aggregator
    public String aggregate(List<String> input)
    {
        StringBuilder stringBuilder = new StringBuilder();
        
        for (String text : input)
        {
            if (text != null)
            {
                stringBuilder.append(text);
                stringBuilder.append(",");
            }
        }
        
        if (stringBuilder.length() > 0)
        {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        
        return stringBuilder.toString();
    }
}

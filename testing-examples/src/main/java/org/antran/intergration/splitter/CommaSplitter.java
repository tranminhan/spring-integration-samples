package org.antran.intergration.splitter;

import java.util.Arrays;
import java.util.List;

import org.springframework.integration.annotation.Splitter;
import org.springframework.util.StringUtils;

public class CommaSplitter
{
    @Splitter
    public List<String> split(String input)
    {
        String[] split = StringUtils.tokenizeToStringArray(input, ",");
        return Arrays.asList(split);
    }
}

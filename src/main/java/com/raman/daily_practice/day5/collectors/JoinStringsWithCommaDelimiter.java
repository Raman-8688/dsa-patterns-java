package com.raman.daily_practice.day5.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinStringsWithCommaDelimiter {
    /**
     * Join strings with comma delimiter using joining() it is terminal operations
     * accept argument 1 " "
     * @param args
     */

    public static void main(String[] args){
        List<String> list= Arrays.asList("Raman","Ravi","Hari");
        String str = list.stream()
                .collect(Collectors.joining(", "));
        System.out.println(str);
    }
}

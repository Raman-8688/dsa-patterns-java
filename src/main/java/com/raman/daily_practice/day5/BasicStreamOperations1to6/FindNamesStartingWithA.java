package com.raman.daily_practice.day5.BasicStreamOperations1to6;

import java.util.Arrays;
import java.util.List;

public class FindNamesStartingWithA {

    public static void main(String[] arg){
        /**
         * Find names starting with “A”
         */
        List<String> str= Arrays.asList("Hello","Aman","Arun","Jai");
        List<String> result=str.stream()
                .filter(s->s.startsWith("A"))
                .toList();
        System.out.println(result);
    }
}

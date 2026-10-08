package com.raman.daily_practice.day5.BasicStreamOperations1to6;

import java.util.Arrays;
import java.util.List;

public class BasicStreamOperations {

    public static void main(String[] arg){
        /**
         * Convert list of strings to uppercase
         */
        String[] arr ={"Hello","Hii","Raman","Mohan","jai"};
        List<String> words= Arrays.asList(arr);
        List<String> result=words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(result);

        /**
         * Filter even numbers
         */




    }
}

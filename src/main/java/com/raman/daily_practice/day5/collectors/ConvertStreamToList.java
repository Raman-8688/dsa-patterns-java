package com.raman.daily_practice.day5.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ConvertStreamToList {

    public static void main(String[] args){
        /**
         * Convert stream to list
         * use stream()
         */
        List<Integer> list= Arrays.asList(2,3,4,5,2,3,4);
        Stream<Integer> result= list.stream();
        System.out.println(result);

    }
}

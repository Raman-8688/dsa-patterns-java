package com.raman.daily_practice.day5.BasicStreamOperations1to6;

import java.util.Arrays;
import java.util.List;

public class CountNumbersGreaterThan10 {
    public static void main(String[] args){
        /**
         * Count numbers greater than 10
         * cont() is terminal operation that return a Long
         */

        List<Integer> list = Arrays.asList(20,1,23,1,22,3,4,5,33);
        Long count=list.stream()
                .filter(n->n>10)
                .count();
        System.out.println(count);

    }
}

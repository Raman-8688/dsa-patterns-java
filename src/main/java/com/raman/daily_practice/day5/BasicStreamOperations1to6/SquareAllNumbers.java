package com.raman.daily_practice.day5.BasicStreamOperations1to6;

import java.util.Arrays;
import java.util.List;

public class SquareAllNumbers {
    /**
     * Square all numbers
     * @param st
     */

    public static void main(String[] st){
        List<Integer> numbers= Arrays.asList(2,3,4,5,6,7,8,9,10,4);
        List<Integer> result = numbers.stream()
                .filter(n->n%2==0)
                .distinct()
                .map(m->m*m)
                .toList();
        System.out.println(result);
    }
}

package com.raman.daily_practice.day5.SortingComparators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortIntegers {

    public static void main(String[] args){
        /**
         * Sorting the List using the sorted method
         */
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,2,3234,23,12,23);
        List<Integer> ass = list.stream()
                .sorted()
                .toList();
        System.out.println(ass);

        /**
         * Descending Order
         */
        List<Integer> des = list.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(des);
    }
}

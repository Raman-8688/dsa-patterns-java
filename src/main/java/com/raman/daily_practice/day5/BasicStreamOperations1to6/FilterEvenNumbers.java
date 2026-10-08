package com.raman.daily_practice.day5.BasicStreamOperations1to6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterEvenNumbers {

    public static void main(String[] args) {
        /**
         * Filter even numbers
         * here convention type normal array having the int but the list accept the object so we
         * use the boxed method here ok
         */
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 11};
        List<Integer> result = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
        System.out.println(result);


        /**
         * stream to
         */

        String[] str = {"hello", "Hii"};
        Stream<String> str2 = Arrays.stream(str)
                .map(String::toUpperCase);
        System.out.println(str2);


        List<Integer> list = Arrays.asList(2,3,4,5,6,7,12);
        List<Integer> rsultList = list.stream()
                .filter(n->n%2==0)
                .toList();
        System.out.println(rsultList);
    }
}

package com.raman.daily_practice.day_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsOperation {

    public static void main(String[] args){
        List<String> list = List.of("Raman","Raghavan","Hari","manisha");
        List<String> result = list.stream()
                .filter(s->s.length()>4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> result1 = list.stream()
                        .filter(s->s.length()<5)
                        .map(String::toUpperCase)
                        .toList();



        System.out.println(result);
        System.out.println(result1);

        /**
         * Remove duplicate we can use the set for remove duplicate or distinct()
         * so if you use the direct set for the collect then you don't need to use again distinct method
         */

        List<Integer> nums = List.of(33,22,2,3,4,5,1,2,8,2,3,4);
        Set<Integer> setResults=nums.stream()
                .sorted()
                .collect(Collectors.toSet());
        System.out.println(setResults);

    }
}

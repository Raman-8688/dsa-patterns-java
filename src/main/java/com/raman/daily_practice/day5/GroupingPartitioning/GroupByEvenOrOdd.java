package com.raman.daily_practice.day5.GroupingPartitioning;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByEvenOrOdd {
    public static void main(String[] args){
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,6,7,7,8,9,10);
        Map<String,List<Integer>> result =list.stream()
                .collect(Collectors.groupingBy(n->n%2==0?"even":"odd"));
        System.out.println(result);



    }
}

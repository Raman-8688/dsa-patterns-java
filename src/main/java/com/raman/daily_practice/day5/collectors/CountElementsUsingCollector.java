package com.raman.daily_practice.day5.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountElementsUsingCollector {

    public static void main(String[] args){
        List<String> list = Arrays.asList("Hello","Hii","well come",null,"king");

        Long count=list.stream()
                .filter(Objects::nonNull)
                .count();
        System.out.println("count of the non null strings:"+count);


        Long countCollector = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.counting());
        System.out.println("using collectors counting():"+countCollector);
    }
}

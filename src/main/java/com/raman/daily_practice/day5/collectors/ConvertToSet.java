package com.raman.daily_practice.day5.collectors;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class ConvertToSet {

    public static void main(String[] args){
        List<String> list= Arrays.asList("A","B","C","D","E","F","B","D","F","F","J");

        Set<String> result=list.stream()
                .collect(Collectors.toSet());
        System.out.println(result);


    }
}

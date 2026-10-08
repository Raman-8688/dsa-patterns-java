package com.raman.daily_practice.day5.BasicStreamOperations1to6;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveNullValues {

    public static void main(String[] args){
        /**
         * Remove null values using Objects::nonNull like in
         * the Objects class we have the nonNull method
         */
        List<String> list= Arrays.asList("Raman",null,"hari","king");
        List<String> result=list.stream()
                .filter(Objects::nonNull)
                .toList();
        System.out.println(result);

    }
}

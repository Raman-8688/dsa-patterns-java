package com.raman.daily_practice.day_4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsOperation {

    public static void main(String[] args){
        List<String> list = List.of("Raman","Raghavan","Hari","manisha");
        List<String> result = list.stream()
                .filter(s->s.length()>4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}

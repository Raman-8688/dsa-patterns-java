package com.raman.daily_practice.day_3;

import java.util.*;

public class SortByValueExample {

    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(342,"Raman");
        map.put(345,"Hari");
        map.put(632,"Ramesh");
        map.put(344,"king");

        List<Map.Entry<Integer,String >> list = new ArrayList<>(map.entrySet());
        //sort by value ascending
       // list.sort(Map.Entry.comparingByValue());
        //list.sort((e1,e2)->e1.getValue().compareTo(e2.getValue()));

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        //list.sort((e1,e2)-> e2.getValue().compareTo(e1.getValue()));
        //list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        /**
         *  here in the sort method we have written some implementation because if not write by default the
         *  sort method having some implementation for the only normal list of Integers but here
         *  we have the Map with entries so that's wy we need to specify that we override that with mentioning exact
         *  what are the values they need to use ok
         */
        Map<Integer,String> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer,String> entry:list){
            sortedMap.put(entry.getKey(),entry.getValue());
        }

        System.out.println(sortedMap);



    }
}

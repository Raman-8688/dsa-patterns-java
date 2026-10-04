package com.raman.daily_practice.day_3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortByKeyExample {

    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(201,"Raman");
        map.put(200,"king");
        map.put(199,"Hello");

        Map<Integer,String> treeMap = new TreeMap<>(map);
        //sorted by key because treeMap sort by default
        System.out.println(treeMap);

    }
}

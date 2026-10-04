package com.raman.daily_practice.day_3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValueHashMapWithStream {
    public static void main(String[] arg) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(342, "Raman");
        map.put(345, "Hari");
        map.put(632, "Ramesh");
        map.put(344, "king");

        Map<Integer, String> sortedMap =
                map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        System.out.println(sortedMap);

    }
}


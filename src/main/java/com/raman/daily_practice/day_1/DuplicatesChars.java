package com.raman.daily_practice.day_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicatesChars {

    public static void main(String[] args){
        String str="Raman Ravan";
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c:str.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();

        for(Map.Entry<Character,Integer>entry: entrySet){
            if(entry.getValue()>1){
                System.out.println("Duplicate Chars:"+entry.getKey()+"-->"+entry.getValue());
            }
        }
        }
    }


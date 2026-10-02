package com.raman.daily_practice.day_2;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurringCharacter {
    public static void main(String args[]){
        String str="Ramannnnn Raghavan";
        String str1="programming";
        System.out.println("Given string:"+str1+" Maximum repeated character is : "+maxRepeat(str1));
    }

    public static char maxRepeat(String str){
        HashMap<Character,Integer> map =new HashMap<>();
        for(char ch: str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int maxCount=0;
        char maxChar=' ';
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()>maxCount){
                maxCount=entry.getValue();
                maxChar=entry.getKey();
            }
        }
        return maxChar;

    }
}

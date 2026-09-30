package com.raman.daily_practice.day_1;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeated {

    public static void main(String[] args){
        String str="Raman Ragavan";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Set<Map.Entry<Character,Integer>> entrySet= map.entrySet();
//        for(Map.Entry<Character,Integer> entry: entrySet){
//          if(entry.getValue()==1){
//              System.out.println("non repeated Characters:"+entry.getKey()+"-->"+entry.getValue());
//              break;
//          }
//        }

        for(char ch:str.toCharArray()){
            if(map.get(ch)==1){
                System.out.println("First Non Repeated Character:"+ch);
                break;
            }
        }
    }

}

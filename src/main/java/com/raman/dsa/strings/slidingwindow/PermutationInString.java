package com.raman.dsa.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean permutationBrute(String s1,String s2){

        int n=s1.length();
        int m=s2.length();
        Map<Character,Integer> map1= new HashMap<>();
        for(int i=0;i<n;i++)
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        for(int i=0;i<m;i++){
            Map<Character,Integer> map2= new HashMap<>();
            for(int j=i;j<m;j++){
                char ch=s2.charAt(j);
                map2.put(ch,map2.getOrDefault(ch,0)+1);
                int len = j-i+1;
                if(len==n){
                    if(map1.equals(map2))
                        return true;
                    break;
                }

            }
        }

        return false;

    }


    public static void main(String[] arg){
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = permutationBrute(s1, s2);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("Permutation Exists: " + result);
    }
}

package com.raman.dsa.strings.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestKSubString {

    public static int longestKSubString(String s,int k){
        int n= s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int max =0;
        int left=0;
        for(int right=0;right<n ;right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            if(map.size()==k){
                max = Math.max(max,right-left+1);
            }
        }
        return max;


    }

    static public  int  longestKSubStringBrut(String s,int k) {
        int max=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();
           for(int j=i;j<n;j++){
               set.add(s.charAt(j));
               if(set.size()==k){
                   max = Math.max(max,j-i+1);
               }
               if(set.size()>k){
                   break;
               }

           }


        }

        return max;
    }


    public static void main(String[] args) {

        String s = "aabacbebebe";
        int k = 3;

        int bruteAns = longestKSubStringBrut(s, k);
        int optimalAns = longestKSubString(s, k);

        System.out.println("String: " + s);
        System.out.println("K = " + k);

        System.out.println("Brute Force Answer : " + bruteAns);
        System.out.println("Optimal Answer     : " + optimalAns);
    }
}

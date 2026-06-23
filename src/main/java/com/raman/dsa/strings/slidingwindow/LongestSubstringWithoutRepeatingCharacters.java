package com.raman.dsa.strings.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstringBrute(String str){
        int n = str.length();
        int max = 0;

        for(int i=0;i<n;i++){
            Set<Character> set = new HashSet<>();
            for(int j=i;j<n;j++){
                char ch = str.charAt(j);
                if(set.contains(ch)){
                    break;
                }
                set.add(ch);
                max = Math.max(max,j-i+1);

            }
        }
        return max;

    }

    public static int lengthOfLongestSubstringOptimal1(String s) {
        int n = s.length();
        int max =0;
        int left=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                left++;

            }

            max=Math.max(max,i-left+1);
        }
        return max;
    }


    public static int lengthOfLongestSubstringOptimal(String s) {
        int n = s.length();
        int max = 0;
        int left=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right =0;right<n;right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(left,map.get(ch)+1);
            }
            map.put(ch,right);
            max = Math.max(max,right-left+1);
        }
        return max;
    }


    public static void main(String[] args) {

        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("Input: " + s1);
        System.out.println("Brute Force: " + lengthOfLongestSubstringBrute(s1));
        System.out.println("Optimal: " + lengthOfLongestSubstringOptimal(s1));

        System.out.println();

        System.out.println("Input: " + s2);
        System.out.println("Brute Force: " + lengthOfLongestSubstringBrute(s2));
        System.out.println("Optimal: " + lengthOfLongestSubstringOptimal(s2));

        System.out.println();

        System.out.println("Input: " + s3);
        System.out.println("Brute Force: " + lengthOfLongestSubstringBrute(s3));
        System.out.println("Optimal: " + lengthOfLongestSubstringOptimal(s3));
    }

}

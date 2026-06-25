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

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int count = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);

            if (freq[ch - 'a'] > 0) {
                count--;
            }

            freq[ch - 'a']--;

            if (count == 0)
                return true;

            if (right - left + 1 == s1.length()) {

                char leftChar = s2.charAt(left);

                if (freq[leftChar - 'a'] >= 0) {
                    count++;
                }

                freq[leftChar - 'a']++;

                left++;
            }
        }

        return false;
    }






    public static boolean checkInclusionOptimal(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int left=0,count=s1.length();
        for(int right=0;right<s2.length();right++){
            char ch = s2.charAt(right);
            int val = map.getOrDefault(ch,0);
            if(val>0){
                count--;
            }
            map.put(ch,val-1);
            if(count==0) return true;
            if(right-left+1==s1.length()){
                char leftChar = s2.charAt(left);
                int leftVal = map.get(leftChar);
                if(leftVal>=0){
                    count++;
                }
                map.put(leftChar,leftVal+1);
                left++;
            }
        }
        return false;
    }




    public static void main(String[] arg){
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = permutationBrute(s1, s2);
        boolean result1 = checkInclusionOptimal(s1, s2);
        //checkInclusionOptimal

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("Permutation Exists: " + result);


        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("Permutation Exists Optimal: " + result1);
    }
}

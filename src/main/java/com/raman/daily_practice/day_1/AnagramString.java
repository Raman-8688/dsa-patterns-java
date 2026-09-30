package com.raman.daily_practice.day_1;

import java.util.Arrays;

public class AnagramString {

    public static void main(String args[]){
        String str ="listen";
        String str1 ="silent";
        char[] arr1 = str.toCharArray();
        char[] arr2 = str1.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("given Strings are Anagrams:"+Arrays.equals(arr2,arr2));
    }
}

package com.raman.daily_practice.day_2;

import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String args[]){
        int arr[]={1,2,3,4,4,12,3,9,10};

        removeDupUsingSet(arr);
    }

    public static void removeDupUsingSet(int arr[]){

        HashSet<Integer> set = new HashSet<>();

        for(int num:arr){
            set.add(num);
        }

        System.out.println("ofter remove:"+set);
    }
}

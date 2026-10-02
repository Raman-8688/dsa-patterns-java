package com.raman.daily_practice.day_2;

import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String args[]){
        int arr[]={1,2,3,4,4,12,3,9,10};

        removeDupUsingSet(arr);

        secondWay(arr);
    }
    public static void secondWay(int a[]){
        System.out.println("second approach");
        HashSet<Integer> set= new HashSet<>();
        for(int num: a){
            set.add(num);

        }

        //converting set to Array
        Integer[] result= set.toArray(new Integer[0]);

        System.out.println("result:"+result);

        System.out.println("Duplicate printing:");
        for(int n:a){
            if(!set.add(n))
                System.out.println(n);
        }
    }

    public static void removeDupUsingSet(int arr[]){

        HashSet<Integer> set = new HashSet<>();

        for(int num:arr){
            set.add(num);
        }

        System.out.println("ofter remove:"+set);
    }
}

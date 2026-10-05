package com.raman.daily_practice.day_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args){
        int[] a ={2,3,1,7,8,2,3,5};
        int[] result= Arrays.stream(a)
//                .filter(n->n%2==0)
                .distinct()
                .toArray();
        System.out.println("Result:"+Arrays.toString(result));
    }
}

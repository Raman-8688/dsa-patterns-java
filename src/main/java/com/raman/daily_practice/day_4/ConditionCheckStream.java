package com.raman.daily_practice.day_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConditionCheckStream {

    public static void main(String[] arg){
        List<Integer> list = Arrays.asList(10, 25, 60, 75, 40, 90, 30);

        /** they given List so we need to convert that inot stream first
         * then is there any condition yes we need to just filter the greater then 50 only
         */
        List<Integer> result =list.stream()
                .filter(number->number>50)
                .collect(Collectors.toList());
        System.out.println(result);

        /**
         * I'm converting the list into a Stream and using the filter() intermediate operation
         * to retain only numbers greater than 50. Since filter() returns another Stream,
         * I use the terminal operation collect() with Collectors.toList() to
         * convert the filtered elements back into a Lis
         */

        List<Integer> result1 =list.stream()
                .filter(number->number<90)
                .collect(Collectors.toList());
        System.out.println(result1);
    }
}

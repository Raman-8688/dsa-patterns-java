package com.raman.dsa.strings.twopointers;

import java.util.Arrays;

public class ReverseString {


    public static void main(String[] args) {
        // Example 1
        char[] s1 = {'h','e','l','l','o'};
        reverseString(s1);
        System.out.println("Reversed: " + Arrays.toString(s1));
        // Output: [o, l, l, e, h]

        // Example 2
        char[] s2 = {'J','a','v','a'};
        reverseString(s2);
        System.out.println("Reversed: " + Arrays.toString(s2));
        // Output: [a, v, a, J]
    }

    private static void reverseString(char[] s1) {
        int left = 0;
        int right = s1.length-1;
        while(left<right){
            char temp=s1[left];
            s1[left] = s1[right];
            s1[right] = temp;
            left++;
            right--;

        }
    }
}

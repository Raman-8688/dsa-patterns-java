package com.raman.dsa.binary_search.classsic_binary_search;

public class BinarySearchSqrt {
    public static void main(String arg[]){
        int[] testCases= {0, 1, 2, 3, 4, 8, 15, 16, 25};

        for(int a:testCases){
            System.out.println("sqrt(" + a + ") = "+sqrt(a));
        }
    }
    public static int sqrt(int a){
        long left=1;
        long right=a/2;
        while(left<=right){
            long mid = left + (right-left)/2;
            long square = mid * mid;
            if(square == a) return (int) mid;
            else if(square<a) left = mid+1;
            else right=mid-1;
        }
        return (int) right;
    }
}

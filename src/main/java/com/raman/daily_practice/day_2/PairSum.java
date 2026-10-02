package com.raman.daily_practice.day_2;

import java.util.Arrays;

public class PairSum {

    public static void main(String args[]) {
        int arr[] = {2, 4, 3, 5, 7, 8, 1};
        findPair(arr, 9);
    }

    public static void findPair(int arr[],int n){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==n){
                System.out.println("Pairs:"+arr[left]+" + "+arr[right]+"="+n);
                left++;
                right--;
            }
            else if(n>sum) left++;
            else right--;
        }
    }
}
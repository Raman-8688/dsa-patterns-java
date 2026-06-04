package com.raman.dsa.prefixsum;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelfBrute(int nums[]){
        int n=nums.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=0;j<n;j++){
                if(i!=j){
                   product*=nums[j];
                }
            }
            result[i]=product;
        }
        return result;

    }


    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int result[] = new ProductOfArrayExceptSelf().productExceptSelfBrute(nums);
        System.out.println("BruteForce:"+ Arrays.toString(result));
    }
}

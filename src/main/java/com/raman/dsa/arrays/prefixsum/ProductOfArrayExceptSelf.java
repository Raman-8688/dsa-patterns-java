package com.raman.dsa.arrays.prefixsum;

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
    public int[] productExceptSelfOptimal(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int rightpro=1;
        for(int r=n-1;r>=0;r--){
            res[r]=res[r]*rightpro;
            rightpro*=nums[r];
        }
        return res;

    }


    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        int result[] = new ProductOfArrayExceptSelf().productExceptSelfBrute(nums);
        int result1[] = new ProductOfArrayExceptSelf().productExceptSelfOptimal(nums);
        System.out.println("BruteForce:"+ Arrays.toString(result));
        System.out.println("BruteForce:"+ Arrays.toString(result1));
    }
}

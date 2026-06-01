package com.raman.dsa.prefixsum;

public class PivotIndex {

    public static int pivotIndexBruteForce(int[] nums){
        int n=nums.length;
        for(int i=0;i<n;i++){
            int leftSum=0;
            for(int j=0;j<i;j++){
                leftSum += nums[j];
            }
            int rightSum =0;
            for(int k=i+1;k<n;k++){
                rightSum += nums[k];
            }
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;

    }
    public static int pivotIndex(int nums[]){
        int n= nums.length;
        int leftSum=0;
        int rightSum=0;
        int total=0;
        for(int num:nums){
            total+=num;
        }

        for(int i=0;i<n;i++){
            rightSum = total-leftSum-nums[i];

            if(leftSum==rightSum){
                return i;
            }
            leftSum += nums[i];

        }
        return -1;

    }

    public static void main(String[] args){
        int[] nums = {1, 7, 3, 6, 5, 6};

        int result = pivotIndex(nums);
        int BruteResult= pivotIndexBruteForce(nums);


        System.out.println("BruteForce = " + BruteResult);
        System.out.println("BruteForce = " + result);
    }
}

package com.raman.dsa.arrays.prefixsum;

import java.util.HashMap;

public class SubArraySumEqualsToK {

    public static int subArraySumBruteForce(int nums[],int k){
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum +=nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    public static int subArraySumOptimized(int nums[],int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int prefixSum=0;
        for(int n:nums){
            prefixSum +=n;
            if(map.containsKey(prefixSum-k)){
                count +=map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;

    }

    public static void main(String args[]){
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println("BruteForce Result: " + subArraySumBruteForce(nums, k));
        System.out.println("Optimized Result: "+ subArraySumOptimized(nums, k));

    }
}

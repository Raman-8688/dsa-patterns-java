package com.raman.dsa.arrays.prefixsum;

import java.util.HashMap;

public class ContinuousSubarraySum {

    public static boolean checkSubarraySumBruteForce(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (j - i + 1 >= 2 && sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkSubarraySumOptmal(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int prefixSum = 0;
        for(int i=0;i<n;i++){
            prefixSum+=nums[i];
            int rem=prefixSum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2){
                    return true;
                }

            }
            else
            {
                map.put(rem,i);
            }

        }
        return false;
    }

    // Main Method for Testing
    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;

        System.out.println("Brute Force Result: " + checkSubarraySumBruteForce(nums, k));
        System.out.println("Optimized Result: " + checkSubarraySumOptmal(nums, k));
    }


}

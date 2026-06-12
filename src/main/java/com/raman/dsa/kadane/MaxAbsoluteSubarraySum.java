package com.raman.dsa.kadane;

public class MaxAbsoluteSubarraySum {
    public static int maxAbsoluteSumBrute(int nums[]){
        int maxSum=0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            int current =0;
            for(int j=i;j<n;j++){
                current += nums[j];
                maxSum = Math.max(maxSum,Math.abs(current));
            }
        }
        return maxSum;
    }
    public static int maxAbsoluteSumOptimal(int nums[]){
        int maxSubArray = kadensMax(nums);
        int minSubArray = kadensMin(nums);
        return Math.max(0,Math.max(maxSubArray,Math.abs(minSubArray)));
    }
    public static int kadensMax(int nums[]){
        int maxSum = nums[0];
        int current = nums[0];
        for(int i=1;i<nums.length;i++){
            current = Math.max(nums[i],current+nums[i]);
            maxSum = Math.max(maxSum,current);
        }
        return maxSum;
    }
    public static int kadensMin(int nums[]){
        int minSum = nums[0];
        int current = nums[0];
        for(int i=1;i<nums.length;i++){
            current = Math.min(nums[i],current+nums[i]);
            minSum = Math.min(minSum,current);
        }
        return  minSum;

    }
    public static void main(String[] args) {
        int[] nums1 = {1, -3, 2, 3, -4};   // Example 1
        int[] nums2 = {-2, -1, -3};        // Example 2
        int[] nums3 = {2, 3, -5, 4};       // Example 3

        System.out.println("Brute Force Results:");
        System.out.println("Example 1: " + MaxAbsoluteSubarraySum.maxAbsoluteSumBrute(nums1));
        System.out.println("Example 2: " + MaxAbsoluteSubarraySum.maxAbsoluteSumBrute(nums2));
        System.out.println("Example 3: " + MaxAbsoluteSubarraySum.maxAbsoluteSumBrute(nums3));

        System.out.println("\nOptimal Results:");
        System.out.println("Example 1: " + MaxAbsoluteSubarraySum.maxAbsoluteSumOptimal(nums1));
        System.out.println("Example 2: " + MaxAbsoluteSubarraySum.maxAbsoluteSumOptimal(nums2));
        System.out.println("Example 3: " + MaxAbsoluteSubarraySum.maxAbsoluteSumOptimal(nums3));
    }
}

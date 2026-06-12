package com.raman.dsa.kadane;

public class MaxSubarraySumCircular {

    public static int maxSubarraySumCircularBrute(int nums[]){
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int currentSum=0;
            for(int j=0;j<n;j++){
                currentSum += nums[(i+j)%n];
                maxSum =Math.max(currentSum,maxSum);
            }

        }
        return maxSum;
    }





    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3 - 2}; // Example 1
        int[] nums2 = {5, -3, 5};     // Example 2
        int[] nums3 = {-3, -2, -3};   // Example 3


        System.out.println("Brute Force Results:");
        System.out.println("Example 1: " + maxSubarraySumCircularBrute(nums1));

        System.out.println("\nOptimal Results:");
       // System.out.println("Example 1: " + maxSubarraySumCircularOptimal(nums1));

    }
}

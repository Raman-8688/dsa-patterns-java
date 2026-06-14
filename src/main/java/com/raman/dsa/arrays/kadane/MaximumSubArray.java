package com.raman.dsa.arrays.kadane;

public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray sol = new MaximumSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Using Kadane's Algorithm
        int maxSum = sol.maxSubArray(nums);
        System.out.println("Maximum Subarray Sum (Kadane's): " + maxSum);

        // Using Brute Force
        int bruteForceSum = sol.maxSubArrayBruteForce(nums);
        System.out.println("Maximum Subarray Sum (Brute Force): " + bruteForceSum);
    }

    private int maxSubArrayBruteForce(int[] nums) {
        int maxSum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }

    private int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currentSum=0;
        for(int n:nums){
            currentSum+=n;
            maxSum=Math.max(maxSum,currentSum);
            if(currentSum<0){
                currentSum=0;
            }
        }
        return maxSum;
    }
}

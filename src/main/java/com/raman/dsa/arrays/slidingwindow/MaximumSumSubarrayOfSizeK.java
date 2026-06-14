package com.raman.dsa.arrays.slidingwindow;

public class MaximumSumSubarrayOfSizeK {

    public static long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        long windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        long maxSum = windowSum;

        for (int right = k; right < n; right++) {
            windowSum += nums[right];
            windowSum -= nums[right - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }
}
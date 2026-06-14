package com.raman.dsa.arrays.slidingwindow;

public class MaxConsecutiveOnesIII {

    /*
        Brute Force Approach
        Time Complexity: O(n²)
    */
    public static int longestOnesBruteForce(int[] nums, int k) {

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            int zeroCount = 0;

            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) {
                    zeroCount++;
                }

                if (zeroCount > k) {
                    break;
                }

                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }

    /*
        Optimized Sliding Window Approach
        Time Complexity: O(n)
    */
    public static int longestOnesOptimal(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println("Brute Force : " +
                longestOnesBruteForce(nums, k));

        System.out.println("Optimized   : " +
                longestOnesOptimal(nums, k));
    }
}
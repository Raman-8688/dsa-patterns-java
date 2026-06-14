package com.raman.dsa.arrays.slidingwindow;

public class SubarrayProductLessThanK {

    /*
        Brute Force Approach
        Time Complexity: O(n²)
    */
    public static int numSubarrayProductLessThanKBruteForce(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int product = 1;

            for (int j = i; j < nums.length; j++) {

                product = product * nums[j];

                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    /*
        Optimized Sliding Window Approach
        Time Complexity: O(n)
    */
    public static int numSubarrayProductLessThanKOptimal(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int product = 1;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            product = product * nums[right];

            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            count = count + (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 6};
        int k = 100;

        System.out.println("Brute Force : " +
                numSubarrayProductLessThanKBruteForce(nums, k));

        System.out.println("Optimized   : " +
                numSubarrayProductLessThanKOptimal(nums, k));
    }
}
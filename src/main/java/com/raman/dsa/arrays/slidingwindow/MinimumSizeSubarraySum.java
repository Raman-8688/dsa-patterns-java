package com.raman.dsa.arrays.slidingwindow;

public class MinimumSizeSubarraySum {

    /*
        Brute Force Approach
        Time Complexity: O(n²)
    */
    public static int minSubArrayLenBruteForce(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;

            for (int j = i; j < nums.length; j++) {

                sum += nums[j];

                if (sum >= target) {

                    minLength = Math.min(minLength, j - i + 1);

                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /*
        Optimized Sliding Window Approach
        Time Complexity: O(n)
    */
    public static int minSubArrayLenOptimal(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                minLength = Math.min(minLength, right - left + 1);

                sum -= nums[left];

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};

        int target = 7;

        System.out.println("Brute Force : " +
                minSubArrayLenBruteForce(target, nums));

        System.out.println("Optimized   : " +
                minSubArrayLenOptimal(target, nums));
    }
}
package com.raman.dsa.slidingwindow;

import java.util.HashMap;

public class SubarrayWithKDistinctIntegers {

    /*
        Brute Force Approach
        Time Complexity: O(n²)
    */
    public static int subarraysWithKDistinctBruteForce(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = i; j < nums.length; j++) {

                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if (map.size() == k) {
                    count++;
                }

                if (map.size() > k) {
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
    public static int subarraysWithKDistinctOptimal(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {

        int left = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            count = count + (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        System.out.println("Brute Force : " +
                subarraysWithKDistinctBruteForce(nums, k));

        System.out.println("Optimized   : " +
                subarraysWithKDistinctOptimal(nums, k));
    }
}
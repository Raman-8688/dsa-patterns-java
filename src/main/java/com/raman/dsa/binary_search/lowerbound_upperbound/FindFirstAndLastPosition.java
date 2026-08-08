package com.raman.dsa.binary_search.lowerbound_upperbound;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    /**
     * Brute Force Approach: Linear Scan
     * Scans through the array to record the first and last indices of target.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] searchRangeBruteForce(int[] nums, int target) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[]{first, last};
    }

    /**
     * Optimal Approach: Dual Binary Search (Lower Bound & Upper Bound variants)
     * Uses two log(n) binary searches to find the first occurrence and last occurrence.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int[] searchRangeOptimal(int[] nums, int target) {
        int first = findFirstPosition(nums, target);

        // If target is not present, no need to search for last position
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = findLastPosition(nums, target);
        return new int[]{first, last};
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; // Keep searching left for earlier occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; // Keep searching right for later occurrences
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};

        int[] targets = {8, 6, 7, 10};

        System.out.println("--- First and Last Position of Element ---");
        for (int target : targets) {
            int[] bruteRes = searchRangeBruteForce(nums, target);
            int[] optRes = searchRangeOptimal(nums, target);

            System.out.println("Target = " + target);
            System.out.println("  Brute Force -> " + Arrays.toString(bruteRes));
            System.out.println("  Optimal BS  -> " + Arrays.toString(optRes));
        }
    }
}

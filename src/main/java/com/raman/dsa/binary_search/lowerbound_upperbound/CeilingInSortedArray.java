package com.raman.dsa.binary_search.lowerbound_upperbound;

public class CeilingInSortedArray {

    /**
     * Brute Force Approach: Linear Search
     * Scans through the array and returns the index of the first element >= x.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findCeilingBruteForce(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= x) {
                return i; // Found the smallest element >= x
            }
        }
        return -1; // No element >= x exists
    }

    /**
     * Optimal Approach: Binary Search (Lower Bound)
     * Uses binary search to find the smallest index where nums[mid] >= x.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findCeilingOptimal(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= x) {
                ans = mid;          // Candidate found, try searching in left half for a smaller valid element
                right = mid - 1;
            } else {
                left = mid + 1;     // nums[mid] < x, ceiling must be in right half
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};

        int[] targets = {5, 20, 0, 10};

        System.out.println("--- Ceiling in Sorted Array ---");
        for (int x : targets) {
            int bruteIdx = findCeilingBruteForce(nums, x);
            int optIdx = findCeilingOptimal(nums, x);

            String bruteVal = (bruteIdx != -1) ? String.valueOf(nums[bruteIdx]) : "None";
            String optVal = (optIdx != -1) ? String.valueOf(nums[optIdx]) : "None";

            System.out.println("Target x = " + x);
            System.out.println("  Brute Force -> Index: " + bruteIdx + ", Value: " + bruteVal);
            System.out.println("  Optimal BS  -> Index: " + optIdx + ", Value: " + optVal);
        }
    }
}

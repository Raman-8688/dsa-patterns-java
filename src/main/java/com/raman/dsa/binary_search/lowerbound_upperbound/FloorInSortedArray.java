package com.raman.dsa.binary_search.lowerbound_upperbound;

public class FloorInSortedArray {

    /**
     * Brute Force Approach: Linear Search
     * Scans from right to left to find the first element <= x (largest element <= x).
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findFloorBruteForce(int[] nums, int x) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= x) {
                return i; // Found largest element <= x
            }
        }
        return -1; // No element <= x exists
    }

    /**
     * Optimal Approach: Binary Search
     * Binary search to find the largest index where nums[mid] <= x.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findFloorOptimal(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= x) {
                ans = mid;         // Candidate found, try searching in right half for a larger valid element
                left = mid + 1;
            } else {
                right = mid - 1;   // nums[mid] > x, floor must be in left half
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};

        int[] targets = {5, 0, 20, 10};

        System.out.println("--- Floor in Sorted Array ---");
        for (int x : targets) {
            int bruteIdx = findFloorBruteForce(nums, x);
            int optIdx = findFloorOptimal(nums, x);

            String bruteVal = (bruteIdx != -1) ? String.valueOf(nums[bruteIdx]) : "None";
            String optVal = (optIdx != -1) ? String.valueOf(nums[optIdx]) : "None";

            System.out.println("Target x = " + x);
            System.out.println("  Brute Force -> Index: " + bruteIdx + ", Value: " + bruteVal);
            System.out.println("  Optimal BS  -> Index: " + optIdx + ", Value: " + optVal);
        }
    }
}

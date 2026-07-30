# Binary Search Insert Position

---

## Problem
Given a sorted array `nums` and a target value, return the index if the target is found.  
If not, return the index where it would be inserted in order.

**Example:**  
Input: `nums = [1,3,5,6], target = 5`  
Output: `2`  
Explanation: `nums[2] = 5`.

---

## Brute Force Approach

### Algorithm
1. Iterate through the array from start to end.
2. Compare each element with the target.
3. If an element equals the target → return its index.
4. If an element is greater than the target → return its index (insert before it).
5. If no element is greater → return `nums.length` (insert at end).

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## Optimal Binary Search Approach

### Algorithm
1. Initialize two pointers:
    - `left = 0`
    - `right = nums.length - 1`
2. While `left ≤ right`:
    - Compute `mid = left + (right - left) / 2`.
    - If `nums[mid] == target` → return `mid`.
    - If `nums[mid] < target` → move search to right half (`left = mid + 1`).
    - If `nums[mid] > target` → move search to left half (`right = mid - 1`).
3. If loop ends without finding target → return `left` (insertion position).

### Complexity
- **Time:** O(log n)
- **Space:** O(1)

---

## Code
```java
package com.raman.dsa.binary_search.classsic_binary_search;

public class BinarySearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        // Test cases
        System.out.println(searchInsert(nums, 2)); // Expected: 1 (insert before 3)
        System.out.println(searchInsert(nums, 7)); // Expected: 4 (insert at end)
        System.out.println(searchInsert(nums, 5)); // Expected: 2 (found at index 2)
        System.out.println(searchInsert(nums, 0)); // Expected: 0 (insert at start)
    }

    public static int searchInsert(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

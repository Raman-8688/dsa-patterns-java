# Find First and Last Position of Element in Sorted Array

---

## Problem
Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.  
If `target` is not found in the array, return `[-1, -1]`.

**Example 1:**  
Input: `nums = [5, 7, 7, 8, 8, 10]`, `target = 8`  
Output: `[3, 4]`

**Example 2:**  
Input: `nums = [5, 7, 7, 8, 8, 10]`, `target = 6`  
Output: `[-1, -1]`

**Example 3:**  
Input: `nums = []`, `target = 0`  
Output: `[-1, -1]`

---

## Approach 1: Brute Force (Linear Scan)

### Algorithm
1. Initialize `first = -1` and `last = -1`.
2. Iterate through the array from `i = 0` to `n - 1`:
    - When `nums[i] == target`:
      - If `first == -1`, update `first = i`.
      - Always update `last = i`.
3. Return `[first, last]`.

### Complexity
- **Time:** $O(n)$ (scans all elements).
- **Space:** $O(1)$.

### Dry Run Example
`nums = [5, 7, 7, 8, 8, 10]`, `target = 8`
- `i = 0`: `5 != 8`
- `i = 1`: `7 != 8`
- `i = 2`: `7 != 8`
- `i = 3`: `8 == 8` → `first = 3`, `last = 3`
- `i = 4`: `8 == 8` → `last = 4`
- `i = 5`: `10 != 8`
- Output: `[3, 4]`

---

## Approach 2: Optimal (Dual Binary Search)

### Algorithm
We perform two separate Binary Searches:

1. **Find First Position (Lower Bound variant):**
    - Standard binary search while `left <= right`.
    - If `nums[mid] == target`:
      - Store candidate: `first = mid`.
      - Keep searching towards left: `right = mid - 1`.
    - Else adjust `left` or `right` standardly.

2. **Find Last Position (Upper Bound variant):**
    - Standard binary search while `left <= right`.
    - If `nums[mid] == target`:
      - Store candidate: `last = mid`.
      - Keep searching towards right: `left = mid + 1`.
    - Else adjust `left` or `right` standardly.

### Complexity
- **Time:** $O(\log n)$ (two binary searches, $O(\log n) + O(\log n) = O(\log n)$).
- **Space:** $O(1)$.

### Dry Run Example
`nums = [5, 7, 7, 8, 8, 10]`, `target = 8`

- **Find First Position:**
  - `left=0, right=5, mid=2` → `nums[2]=7 < 8` → `left = 3`
  - `left=3, right=5, mid=4` → `nums[4]=8 == 8` → `first=4, right=3`
  - `left=3, right=3, mid=3` → `nums[3]=8 == 8` → `first=3, right=2`
  - Loop ends. `first = 3`.

- **Find Last Position:**
  - `left=0, right=5, mid=2` → `nums[2]=7 < 8` → `left = 3`
  - `left=3, right=5, mid=4` → `nums[4]=8 == 8` → `last=4, left=5`
  - `left=5, right=5, mid=5` → `nums[5]=10 > 8` → `right=4`
  - Loop ends. `last = 4`.

- Output: `[3, 4]`

---

## Code
```java
package com.raman.dsa.binary_search.lowerbound_upperbound;

import java.util.Arrays;

public class FindFirstAndLastPosition {

    // Brute Force Approach - O(n)
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

    // Optimal Approach - Dual Binary Search - O(log n)
    public static int[] searchRangeOptimal(int[] nums, int target) {
        int first = findFirstPosition(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLastPosition(nums, target);
        return new int[]{first, last};
    }

    private static int findFirstPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; // Keep checking left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }

    private static int findLastPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; // Keep checking right
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

        System.out.println(Arrays.toString(searchRangeOptimal(nums, 8))); // [3, 4]
        System.out.println(Arrays.toString(searchRangeOptimal(nums, 6))); // [-1, -1]
    }
}
```

---

## Why These Work
- **Brute Force:** Scans sequentially from start to finish, storing the index when `target` is first seen and continuously updating `last`.
- **Dual Binary Search:** Even when `nums[mid] == target`, standard binary search would stop. Here, we **don't stop**:
  - To find the **first** occurrence, we record `mid` and continue squeezing the search space to the left (`right = mid - 1`).
  - To find the **last** occurrence, we record `mid` and continue squeezing the search space to the right (`left = mid + 1`).

---

## 🔑 Remember Trick
Think of **finding duplicate books on a shelf**:
- When you spot your book at `mid`, don't stop!
- **First Position:** Peek to the left side to find where the sequence of identical books *starts*.
- **Last Position:** Peek to the right side to find where the sequence of identical books *ends*.

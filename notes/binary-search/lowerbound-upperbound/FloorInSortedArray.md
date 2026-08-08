# Floor in a Sorted Array

---

## Problem
Given a sorted array `nums` of `n` integers and a target value `x`, find the **floor** of `x` in the array.  
The **floor** of `x` is defined as the **largest element in `nums` that is smaller than or equal to `x`** (`nums[i] <= x`).  
If no such element exists, return `-1`.

**Example 1:**  
Input: `nums = [1, 2, 8, 10, 10, 12, 19]`, `x = 5`  
Output: Index `1` (Value `2`)  
Explanation: `2` is the largest element in `nums` that is $\le 5$.

**Example 2:**  
Input: `nums = [1, 2, 8, 10, 10, 12, 19]`, `x = 0`  
Output: Index `-1`  
Explanation: No element in the array is $\le 0$.

---

## Approach 1: Brute Force (Linear Search)

### Algorithm
1. Traverse the array from **right to left** (`i = n - 1` down to `0`).
2. The **first** element encountered that satisfies `nums[i] <= x` is the floor because elements decrease as we move left.
3. Return `i`.
4. If loop finishes without finding any element $\le x$, return `-1`.

### Complexity
- **Time:** $O(n)$
- **Space:** $O(1)$

### Dry Run Example
`nums = [1, 2, 8, 10, 12]`, `x = 5`
- `i = 4`: `nums[4] = 12 > 5` → Continue
- `i = 3`: `nums[3] = 10 > 5` → Continue
- `i = 2`: `nums[2] = 8 > 5` → Continue
- `i = 1`: `nums[1] = 2 <= 5` → Return index `1` (Value `2`).

---

## Approach 2: Optimal (Binary Search)

### Algorithm
1. Initialize two pointers:
    - `left = 0`
    - `right = nums.length - 1`
    - `ans = -1`
2. While `left <= right`:
    - Compute `mid = left + (right - left) / 2`.
    - If `nums[mid] <= x`:
      - Store candidate index: `ans = mid`.
      - Search right half to check for a larger valid floor: `left = mid + 1`.
    - Else (`nums[mid] > x`):
      - Search left half: `right = mid - 1`.
3. Return `ans`.

### Complexity
- **Time:** $O(\log n)$
- **Space:** $O(1)$

### Dry Run Example
`nums = [1, 2, 8, 10, 12]`, `x = 5`
- **Step 1:** `left = 0, right = 4, mid = 2` → `nums[2] = 8 > 5`.  
  - Search left half (`right = 1`).
- **Step 2:** `left = 0, right = 1, mid = 0` → `nums[0] = 1 <= 5`.  
  - Store `ans = 0`. Search right half (`left = 1`).
- **Step 3:** `left = 1, right = 1, mid = 1` → `nums[1] = 2 <= 5`.  
  - Store `ans = 1`. Search right half (`left = 2`).
- Loop ends (`left > right`). Output: `ans = 1` (Value `2`).

---

## Code
```java
package com.raman.dsa.binary_search.lowerbound_upperbound;

public class FloorInSortedArray {

    // Brute Force Approach - O(n)
    public static int findFloorBruteForce(int[] nums, int x) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= x) {
                return i;
            }
        }
        return -1;
    }

    // Optimal Binary Search Approach - O(log n)
    public static int findFloorOptimal(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= x) {
                ans = mid;
                left = mid + 1; // Look right for potentially larger floor
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};

        System.out.println(findFloorOptimal(nums, 5)); // Output: 1 (Value: 2)
        System.out.println(findFloorOptimal(nums, 0)); // Output: -1
    }
}
```

---

## Why These Work
- **Brute Force:** Reversing direction (scanning from right to left) immediately hits the largest element $\le x$.
- **Binary Search:** Whenever `nums[mid] <= x`, it is a valid floor candidate, but we expand towards the right (`left = mid + 1`) to see if a larger valid element $\le x$ exists.

---

## 🔑 Remember Trick
Think of **buying items under budget $x$**:
- You want the **most expensive item** you can buy without exceeding $x$ (Floor).
- If `mid` price is $\le x$, you can afford it! Record it, but look right to see if you can buy something even better under budget.
- If `mid` price is $> x$, it's out of your budget, so look left for cheaper items!

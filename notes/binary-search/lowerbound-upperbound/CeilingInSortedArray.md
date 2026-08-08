# Ceiling in a Sorted Array

---

## Problem
Given a sorted array `nums` of `n` integers and a target value `x`, find the **ceiling** of `x` in the array.  
The **ceiling** of `x` is defined as the **smallest element in `nums` that is greater than or equal to `x`** (`nums[i] >= x`).  
If no such element exists, return `-1`.

**Example 1:**  
Input: `nums = [1, 2, 8, 10, 10, 12, 19]`, `x = 5`  
Output: Index `2` (Value `8`)  
Explanation: `8` is the smallest element in `nums` that is $\ge 5$.

**Example 2:**  
Input: `nums = [1, 2, 8, 10, 10, 12, 19]`, `x = 20`  
Output: Index `-1`  
Explanation: No element in the array is $\ge 20$.

---

## Approach 1: Brute Force (Linear Search)

### Algorithm
1. Traverse the array from start (`i = 0`) to end (`i = n - 1`).
2. At each element `nums[i]`, check if `nums[i] >= x`.
3. The **first** element that satisfies `nums[i] >= x` is the ceiling because the array is sorted in non-decreasing order.
4. Return `i`.
5. If the loop finishes without finding any element $\ge x$, return `-1`.

### Complexity
- **Time:** $O(n)$ (in the worst case, we might scan the entire array).
- **Space:** $O(1)$ (no extra memory used).

### Dry Run Example
`nums = [1, 2, 8, 10, 12]`, `x = 5`
- `i = 0`: `nums[0] = 1 < 5` → Continue
- `i = 1`: `nums[1] = 2 < 5` → Continue
- `i = 2`: `nums[2] = 8 >= 5` → Return index `2` (Value `8`).

---

## Approach 2: Optimal (Binary Search / Lower Bound)

### Algorithm
1. Initialize two pointers:
    - `left = 0`
    - `right = nums.length - 1`
    - `ans = -1`
2. While `left <= right`:
    - Compute `mid = left + (right - left) / 2`.
    - If `nums[mid] >= x`:
      - Store candidate index: `ans = mid`.
      - Search left half to check for a smaller valid ceiling: `right = mid - 1`.
    - Else (`nums[mid] < x`):
      - Search right half: `left = mid + 1`.
3. Return `ans`.

### Complexity
- **Time:** $O(\log n)$ (search space is halved each step).
- **Space:** $O(1)$.

### Dry Run Example
`nums = [1, 2, 8, 10, 12]`, `x = 5`
- **Step 1:** `left = 0, right = 4, mid = 2` → `nums[2] = 8 >= 5`.  
  - Store `ans = 2`. Search left half (`right = 1`).
- **Step 2:** `left = 0, right = 1, mid = 0` → `nums[0] = 1 < 5`.  
  - Search right half (`left = 1`).
- **Step 3:** `left = 1, right = 1, mid = 1` → `nums[1] = 2 < 5`.  
  - Search right half (`left = 2`).
- Loop ends (`left > right`). Output: `ans = 2` (Value `8`).

---

## Code
```java
package com.raman.dsa.binary_search.lowerbound_upperbound;

public class CeilingInSortedArray {

    // Brute Force Approach - O(n)
    public static int findCeilingBruteForce(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= x) {
                return i;
            }
        }
        return -1;
    }

    // Optimal Binary Search Approach - O(log n)
    public static int findCeilingOptimal(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= x) {
                ans = mid;
                right = mid - 1; // Look left for potentially smaller ceiling
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 8, 10, 10, 12, 19};

        System.out.println(findCeilingOptimal(nums, 5));  // Output: 2 (Value: 8)
        System.out.println(findCeilingOptimal(nums, 20)); // Output: -1
    }
}
```

---

## Why These Work
- **Brute Force:** Linear scan takes advantage of array order by stopping at the first element $\ge x$.
- **Binary Search (Lower Bound):** We are finding the **Lower Bound** of `x`. Whenever `nums[mid] >= x`, it is a valid ceiling candidate, but we keep shrinking the search window to the left (`right = mid - 1`) to ensure we get the *smallest* element $\ge x$.

---

## 🔑 Remember Trick
Think of **buying tickets at a concert**:
- You need a ticket tier that costs **at least $x$** (Ceiling).
- If `mid` price is $\ge x$, you record that tier, but check if there's a cheaper valid tier on the left side.
- If `mid` price is $< x$, you can't afford it, so search higher tiers on the right!

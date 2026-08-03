# Find Minimum in Rotated Sorted Array

---

## Problem
Given a rotated sorted array `nums` (with no duplicates), return the **minimum element**.

**Example:**  
Input: `nums = [4,5,6,7,0,1,2]`  
Output: `0`  
Explanation: The smallest element is `0`.

---

## Why This is Difficult
- A normal sorted array’s minimum is always at index `0`.
- But after rotation, the smallest element shifts to somewhere in the middle.
- We must use binary search logic to efficiently locate it.

---

## Algorithm (Step by Step)

1. **Initialize pointers**:
    - `left = 0`
    - `right = nums.length - 1`

2. **Loop until `left < right`**:
    - Compute `mid = left + (right - left) / 2`.
    - Compare `nums[mid]` with `nums[right]`.

3. **Decide which half to search**:
    - If `nums[mid] ≤ nums[right]`:  
      → The minimum lies in the **left half**, including `mid`.  
      → Move `right = mid`.
    - Else (`nums[mid] > nums[right]`):  
      → The minimum lies in the **right half**, excluding `mid`.  
      → Move `left = mid + 1`.

4. **Loop ends when `left == right`**:
    - At this point, both pointers converge on the minimum element.
    - Return `nums[left]`.

---

## Complexity
- **Time:** O(log n) (binary search halves the search space each step).
- **Space:** O(1).

---

## Dry Run Example
**Input:** `nums = [4,5,6,7,0,1,2]`

- Step 1: `left=0, right=6, mid=3 → nums[3]=7 > nums[6]=2 → left=4`.
- Step 2: `left=4, right=6, mid=5 → nums[5]=1 ≤ nums[6]=2 → right=5`.
- Step 3: `left=4, right=5, mid=4 → nums[4]=0 ≤ nums[5]=1 → right=4`.
- Loop ends (`left=4, right=4`).
- Return `nums[4] = 0`.

**Output:** `0`

---

## Why This Works
- In a rotated sorted array, one half is always sorted.
- By comparing `nums[mid]` with `nums[right]`, we can decide which half contains the minimum.
- This ensures we still eliminate half the search space each step.

---

## 🔑 Remember Trick
Think of a **rotated clock dial**:
- The smallest number (like `0`) is the point where the dial “resets.”
- If the middle number is smaller than the rightmost number → the reset point is on the left side.
- If the middle number is larger → the reset point is on the right side.
- Keep narrowing until you land exactly on the reset point — that’s the minimum.

---

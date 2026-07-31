# Search Target in Rotated Sorted Array

---

## Problem
You are given a sorted array that has been **rotated at some pivot** unknown to you beforehand.  
Your task is to search for a target value and return its index if found.  
If not found, return `-1`.

**Example:**  
Input: `nums = [4,5,6,7,1,2,3], target = 7`  
Output: `3`  
Explanation: `nums[3] = 7`.

---

## Why This is Difficult
- A normal binary search works only on a fully sorted array.
- Here, the array is sorted but **rotated**, meaning one half is sorted while the other half is "broken".
- We must first identify which half is sorted before deciding where to search.

---

## Algorithm (Step by Step)

1. **Initialize pointers**:
    - `left = 0`
    - `right = nums.length - 1`

2. **Loop until `left ≤ right`**:
    - Compute `mid = left + (right - left) / 2`.
    - If `nums[mid] == target` → return `mid`.

3. **Check which half is sorted**:
    - If `nums[left] ≤ nums[mid]`:  
      → Left half is sorted.
        - If `target` lies between `nums[left]` and `nums[mid]` (inclusive of left, exclusive of mid):  
          → Move search to left half (`right = mid - 1`).
        - Else:  
          → Move search to right half (`left = mid + 1`).

    - Else (meaning `nums[mid] < nums[right]`):  
      → Right half is sorted.
        - If `target` lies between `nums[mid]` and `nums[right]` (exclusive of mid, inclusive of right):  
          → Move search to right half (`left = mid + 1`).
        - Else:  
          → Move search to left half (`right = mid - 1`).

4. **If loop ends without finding target**:
    - Return `-1`.

---

## Complexity
- **Time:** O(log n) (binary search halves the search space each step).
- **Space:** O(1).

---

## Dry Run Example
**Input:** `nums = [4,5,6,7,1,2,3], target = 1`

- Step 1: `left=0, right=6, mid=3 → nums[3]=7 ≠ 1`.
- Step 2: Left half `[4,5,6,7]` is sorted. Target `1` not in `[4..7]`. → Move right (`left=4`).
- Step 3: `left=4, right=6, mid=5 → nums[5]=2 ≠ 1`.
- Step 4: Right half `[1,2,3]` is sorted. Target `1` lies in `[1..2]`. → Move left (`right=4`).
- Step 5: `left=4, right=4, mid=4 → nums[4]=1 == target`. Return `4`.

**Output:** `4`

---

## Why This Works
- Even though the array is rotated, **one half is always sorted**.
- By checking which half is sorted, we can decide whether the target lies in that half or the other.
- This ensures we still eliminate half the search space each step, keeping efficiency.

---

## 🔑 Remember Trick
Think of a **rotated bookshelf**:
- Books are still in order, but the shelf starts from the middle.
- If you open at a random point, one side of the shelf is neatly ordered, the other side wraps around.
- First check which side is properly ordered.
- Then decide if your book (target) belongs there or on the other side.
- Keep narrowing until you find it or confirm it’s missing.

That’s binary search in a rotated array!

---

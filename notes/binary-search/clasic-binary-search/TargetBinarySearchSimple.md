# Binary Search (Iterative and Recursive)

## Problem
Given a sorted array `nums` and a target value, return the index of the target if it exists.  
If not, return `-1`.

Example:  
Input: `nums = [-1,0,3,5,9,12], target = 9`  
Output: `4`  
Explanation: `nums[4] = 9`.

---

## Brute Force Approach

### Algorithm
1. Iterate through the array from start to end.
2. Compare each element with the target.
3. If found → return index.
4. If not found after full traversal → return `-1`.

### Complexity
- **Time:** O(n) (linear scan).
- **Space:** O(1).

---

## Optimal Iterative Binary Search

### Algorithm
1. Initialize two pointers:
    - `left = 0`
    - `right = nums.length - 1`
2. While `left <= right`:
    - Compute `mid = left + (right - left) / 2` (avoids overflow).
    - If `nums[mid] == target` → return `mid`.
    - If `nums[mid] < target` → move `left = mid + 1`.
    - If `nums[mid] > target` → move `right = mid - 1`.
3. If loop ends without finding target → return `-1`.

### Complexity
- **Time:** O(log n) (array halved each step).
- **Space:** O(1).

---

## Recursive Binary Search

### Algorithm
1. Base case: if `left > right` → return `-1`.
2. Compute `mid = left + (right - left) / 2`.
3. If `nums[mid] == target` → return `mid`.
4. If `nums[mid] < target` → recursively search right half (`mid+1` to `right`).
5. If `nums[mid] > target` → recursively search left half (`left` to `mid-1`).

### Complexity
- **Time:** O(log n).
- **Space:** O(log n) (due to recursive call stack).

---

## Dry Run Example
Input: `nums = [-1,0,3,5,9,12], target = 9`

- Iterative:
    - `left=0, right=5, mid=2 → nums[2]=3 < target → left=3`.
    - `left=3, right=5, mid=4 → nums[4]=9 == target → return 4`.

- Recursive:
    - Call with `left=0, right=5, mid=2 → nums[2]=3 < target → recurse right`.
    - Call with `left=3, right=5, mid=4 → nums[4]=9 == target → return 4`.

Output: **4**

---

## Why Binary Search Works
- The array is sorted.
- Each comparison eliminates half of the search space.
- This logarithmic reduction makes it highly efficient compared to linear search.

---

## 🔑 Remember Trick
Think of **looking up a word in a dictionary**:
- Instead of flipping page by page, you open the middle.
- If the word is alphabetically before → search left half.
- If after → search right half.
- Repeat until found or no pages left.
- That’s binary search in action.

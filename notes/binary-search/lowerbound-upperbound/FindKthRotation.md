# Rotate Array (Three Approaches)

---

## Problem
Given an array `nums` and an integer `k`, rotate the array to the right by `k` steps.  
Rotation means shifting elements so that the last element moves to the front, and all others move one step right.

**Example:**  
Input: `nums = [1,2,3,4,5,6,7], k = 3`  
Output: `[5,6,7,1,2,3,4]`

---

## Approach 1: Brute Force (Rotate One by One)

### Algorithm
1. Repeat the following `k` times:
    - Store the last element in a temporary variable.
    - Shift all elements one step to the right.
    - Place the stored element at the front.
2. After `k` iterations, the array is rotated.

### Complexity
- **Time:** O(n × k) (each rotation requires shifting `n` elements).
- **Space:** O(1).

### Dry Run Example
`nums = [1,2,3], k = 2`
- First rotation → `[3,1,2]`
- Second rotation → `[2,3,1]`

---

## Approach 2: Extra Array (Index Mapping)

### Algorithm
1. Compute `k = k % n` (to handle cases where `k > n`).
2. Create a temporary array of size `n`.
3. For each index `i` in the original array:
    - Compute new index = `(i + k) % n`.
    - Place `nums[i]` at `temp[newIndex]`.
4. Copy all elements from `temp` back into `nums`.

### Complexity
- **Time:** O(n).
- **Space:** O(n) (extra array required).

### Dry Run Example
`nums = [1,2,3,4], k = 2`
- Mapping:
    - `1 → index (0+2)%4=2`
    - `2 → index (1+2)%4=3`
    - `3 → index (2+2)%4=0`
    - `4 → index (3+2)%4=1`
- Result: `[3,4,1,2]`

---

## Approach 3: Reverse Method (Optimal)

### Algorithm
1. Compute `k = k % n`.
2. Reverse the entire array.
3. Reverse the first `k` elements.
4. Reverse the remaining `n-k` elements.
5. The array is now rotated.

### Complexity
- **Time:** O(n).
- **Space:** O(1).

### Dry Run Example
`nums = [1,2,3,4,5,6,7], k = 3`
- Step 1: Reverse entire array → `[7,6,5,4,3,2,1]`
- Step 2: Reverse first 3 → `[5,6,7,4,3,2,1]`
- Step 3: Reverse last 4 → `[5,6,7,1,2,3,4]`

---

## Why These Work
- **Brute Force:** Direct simulation of rotation.
- **Extra Array:** Uses modular arithmetic to map old indices to new ones.
- **Reverse Method:** Clever trick — reversing segments achieves rotation in-place.

---

## 🔑 Remember Trick
Think of **rotating chairs in a circle**:
- **Brute Force:** Move one person at a time, repeat `k` times.
- **Extra Array:** Assign each person directly to their new chair using math.
- **Reverse Method:** Flip the whole circle, then flip groups back — everyone ends up rotated perfectly.

---

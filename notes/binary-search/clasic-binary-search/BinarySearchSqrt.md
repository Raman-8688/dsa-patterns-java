# Square Root using Binary Search

---

## Problem
Given a non-negative integer `x`, return the **floor value** of its square root.  
The floor means the largest integer `y` such that `y * y ≤ x`.

**Example:**  
Input: `x = 8`  
Output: `2`  
Explanation: `sqrt(8) ≈ 2.82`, floor is `2`.

---

## Brute Force Approach

### Algorithm
1. Start from `i = 0`.
2. Increment `i` until `i * i > x`.
3. Return `i - 1` as the floor square root.

### Complexity
- **Time:** O(√x)
- **Space:** O(1)

---

## Optimal Binary Search Approach

### Algorithm
1. Handle small inputs directly:
    - If `x < 2`, return `x` (since sqrt(0)=0, sqrt(1)=1).
2. Initialize search boundaries:
    - `left = 1`
    - `right = x / 2` (because sqrt(x) ≤ x/2 for x ≥ 2).
3. While `left ≤ right`:
    - Compute `mid = left + (right - left) / 2`.
    - Compute `square = mid * mid`.
    - If `square == x` → return `mid`.
    - If `square < x` → move search to the right half (`left = mid + 1`).
    - If `square > x` → move search to the left half (`right = mid - 1`).
4. When the loop ends, `right` will be the floor of sqrt(x). Return `right`.

### Complexity
- **Time:** O(log x)
- **Space:** O(1)

---

## Dry Run Example
**Input:** `x = 8`

- Step 1: `left=1, right=4, mid=2 → square=4 < 8 → left=3`
- Step 2: `left=3, right=4, mid=3 → square=9 > 8 → right=2`
- Loop ends (`left=3, right=2`), return `right=2`.

**Output:** `2`

---

## Why Binary Search Works
- We are searching for the largest integer whose square is ≤ `x`.
- Each comparison eliminates half of the possible candidates.
- This logarithmic reduction makes it highly efficient compared to brute force.

---

## 🔑 Remember Trick
Think of **finding the right shoe size**:
- If the shoe is too small → try a bigger size (move right).
- If the shoe is too big → try a smaller size (move left).
- Keep narrowing until you find the perfect fit or the closest smaller size.

That’s binary search for square roots!

---

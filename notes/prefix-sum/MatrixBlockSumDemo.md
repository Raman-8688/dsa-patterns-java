# Matrix Block Sum (Brute Force Approach)

## Problem
Given a matrix `mat` and integer `k`, for each cell `(i, j)` compute the sum of all elements within a block of radius `k` centered at `(i, j)`.

---

## Brute Force Algorithm
1. For each cell `(i, j)`:
    - Initialize `sum = 0`.
    - Iterate rows from `i-k` to `i+k`.
    - Iterate cols from `j-k` to `j+k`.
    - If `(r, c)` is inside matrix boundaries, add `mat[r][c]` to sum.
    - Store sum in result matrix.

---

## Complexity
- Time: **O(m * n * k^2)**
- Space: **O(m * n)**

---

## Golden Trick
Think of the block as a **sliding window square** around each cell.  
Brute force = scanning neighbors one by one.  
Optimized = use **2D prefix sum** to query block sums instantly.

---


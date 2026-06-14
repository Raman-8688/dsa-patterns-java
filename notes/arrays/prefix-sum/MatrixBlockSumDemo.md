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

# Matrix Block Sum (Optimal Prefix Sum Approach)

## Problem
Given a matrix `mat` and integer `k`, for each cell `(i, j)` compute the sum of all elements within a block of radius `k` centered at `(i, j)`.

---

## Optimal Algorithm (Prefix Sum)
1. Build a **2D prefix sum array** where `prefix[i][j]` stores the sum of all elements from `(0,0)` to `(i-1,j-1)`.
   - Formula:
     ```
     prefix[i][j] = mat[i-1][j-1] 
                  + prefix[i-1][j] 
                  + prefix[i][j-1] 
                  - prefix[i-1][j-1]
     ```
2. For each cell `(i, j)`:
   - Define block boundaries:
      - `r1 = max(0, i-k)`
      - `c1 = max(0, j-k)`
      - `r2 = min(m-1, i+k)`
      - `c2 = min(n-1, j+k)`
   - Convert to prefix indices (+1).
   - Query block sum using:
     ```
     sum = prefix[r2][c2] 
         - prefix[r1-1][c2] 
         - prefix[r2][c1-1] 
         + prefix[r1-1][c1-1]
     ```
3. Store result in `answer[i][j]`.

---

## Complexity
- Build prefix sum: **O(m * n)**
- Each query: **O(1)**
- Total: **O(m * n)** → much faster than brute force.

---

## Golden Trick
👉 **Prefix sum = instant balance check.**  
Instead of counting coins one by one (brute force), you check your cumulative balance and subtract to get any block sum in O(1).

---





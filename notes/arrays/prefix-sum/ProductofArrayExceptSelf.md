# Product of Array Except Self

## Problem Statement
Given an integer array `nums`, return an array `res` such that `res[i]` is the product of all elements of `nums` except `nums[i]`.

---

## Brute Force Approach

### Algorithm
1. Initialize an empty result array `res` of size `n`.
2. For each index `i`:
   - Set `product = 1`.
   - Loop through all indices `j`:
      - If `i != j`, multiply `product *= nums[j]`.
   - Store `res[i] = product`.
3. Return `res`.

### Explanation
- For each element, we calculate the product of all other elements by looping through the array again.
- This means we repeat a lot of multiplications, making it inefficient.

### Dry Run (nums = {1, 2, 3, 4})
- i=0 → 2*3*4 = 24
- i=1 → 1*3*4 = 12
- i=2 → 1*2*4 = 8
- i=3 → 1*2*3 = 6  
  Result: `[24, 12, 8, 6]`

### Complexity
- Time: **O(n²)**
- Space: **O(1)** extra

### Golden Trick
Think of it as:  
**“For each seat, multiply everyone else sitting in the row.”**

---

## Optimized Approach (Prefix + Suffix Products)

### Algorithm
1. Create result array `res` of size `n`.
2. First pass (left products):
   - Set `res[0] = 1`.
   - For each `i` from 1 to n-1:
      - `res[i] = res[i-1] * nums[i-1]`.
   - Now `res[i]` holds product of all elements to the **left** of `i`.
3. Second pass (right products):
   - Initialize `rightpro = 1`.
   - Traverse from right to left:
      - Update `res[r] = res[r] * rightpro`.
      - Update `rightpro *= nums[r]`.
   - This multiplies in the product of all elements to the **right** of `r`.
4. Return `res`.

### Explanation
- First loop builds **prefix products** (everything before index `i`).
- Second loop multiplies in **suffix products** (everything after index `i`).
- Together, each index gets product of all except itself.

### Dry Run (nums = {1, 2, 3, 4})
- After left pass: `res = [1, 1, 2, 6]`
- Right pass:
   - r=3 → res[3] = 6*1 = 6, rightpro=4
   - r=2 → res[2] = 2*4 = 8, rightpro=12
   - r=1 → res[1] = 1*12 = 12, rightpro=24
   - r=0 → res[0] = 1*24 = 24  
     Result: `[24, 12, 8, 6]`

### Complexity
- Time: **O(n)**
- Space: **O(1)** extra

### Golden Trick
Imagine two hands:
- **Left hand** carries product of all elements before you.
- **Right hand** carries product of all elements after you.  
  At each seat, multiply what both hands carry → product except self.

---

## Key Learnings
- Brute force repeats multiplications → inefficient.
- Optimized approach cleverly splits into **prefix (left)** and **suffix (right)** products.
- This reduces complexity from **O(n²)** to **O(n)** with constant extra space.  

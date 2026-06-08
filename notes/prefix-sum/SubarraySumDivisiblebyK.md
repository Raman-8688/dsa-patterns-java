# Subarray Sum Divisible by K

## 🔹 Problem Statement
We are given an integer array `nums` and an integer `k`.  
We need to find the number of **non-empty subarrays** whose sum is divisible by `k`.

- A **subarray** is a continuous portion of the array.
- "Divisible by k" means the subarray sum satisfies: `sum % k == 0`.

### Example
nums = [4, 5, 0, -2, -3, 1], k = 5

Valid subarrays include `[5]`, `[0]`, `[5,0]`, `[0,-2,-3]`, etc.  
Answer = **7**

---

## 🔹 Brute Force Algorithm

### Steps
1. Initialize `count = 0`.
2. Loop over all starting indices `i`.
3. For each `i`, loop over ending indices `j >= i`.
4. Compute the sum of subarray `nums[i...j]`.
5. If `(sum % k == 0)`, increment `count`.
6. Return `count`.

### Complexity
- **Time Complexity:** \(O(n^2)\) (checking all subarrays).
- **Space Complexity:** \(O(1)\).

### Intuition
We simply check every possible subarray and count those divisible by `k`.  
Easy to understand, but very slow for large arrays.

---

## 🔹 Optimized Algorithm (Prefix Sum + HashMap)

### Key Idea
- Use **prefix sums** and track remainders modulo `k`.
- If two prefix sums have the same remainder, their difference is divisible by `k`.
- Store counts of remainders in a HashMap.

### Steps
1. Initialize a map with `{0:1}` (to handle subarrays starting at index 0).
2. Maintain a running `prefix` sum.
3. For each element:
    - Compute `rem = prefix % k`.
    - If `rem < 0`, adjust by adding `k` (to handle negatives).
    - If `rem` exists in `map`, add its frequency to `count`.
    - Update `map` with `rem`.
4. Return `count`.

### Complexity
- **Time Complexity:** \(O(n)\) (single pass).
- **Space Complexity:** \(O(k)\) (map stores remainders).

### Intuition
Instead of checking all subarrays, we use the **remainder trick**:  
If two prefix sums give the same remainder, the subarray between them is divisible by `k`.

---

## 🔹 Simple Backtracking Dry Run (Optimized Approach)

Let’s dry run with `nums = [4,5,0,-2,-3,1], k = 5`.

- Start: `map = {0:1}`, `prefix = 0`, `count = 0`
- Add 4 → prefix=4, rem=4 → map={0:1,4:1}
- Add 5 → prefix=9, rem=4 → count+=1 → map={0:1,4:2}
- Add 0 → prefix=9, rem=4 → count+=2 → map={0:1,4:3}
- Add -2 → prefix=7, rem=2 → map={0:1,4:3,2:1}
- Add -3 → prefix=4, rem=4 → count+=3 → map={0:1,4:4,2:1}
- Add 1 → prefix=5, rem=0 → count+=1 → map={0:2,4:4,2:1}

Final `count = 7`.

---

## ✅ Summary
- **Brute Force:** Easy but slow (\(O(n^2)\)).
- **Optimized:** Efficient with prefix sums + HashMap (\(O(n)\)).
- **Memory Trick:** Always initialize `map.put(0,1)` to count subarrays starting at index 0.

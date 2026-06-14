# Continuous Subarray Sum (Good Subarray Problem)

##  Problem Statement
We need to check if there exists a **continuous subarray** of length ≥ 2 whose sum is divisible by `k`.

---

##  Brute Force Approach

### Explanation
- Try all possible subarrays.
- For each subarray, calculate the sum.
- If the sum is divisible by `k` and length ≥ 2 → return true.

### Algorithm
1. Loop over all starting indices `i`.
2. For each `i`, loop over ending indices `j`.
3. Compute sum of subarray `nums[i..j]`.
4. If `(j - i + 1) >= 2` and `(sum % k == 0)` → good subarray found.
5. If no subarray satisfies, return false.

⏱️ Time Complexity: **O(n²)**  
📦 Space Complexity: **O(1)**

---

## ⚡ Optimized Approach (Prefix Sum + HashMap)

### Explanation
- Use prefix sums and modular arithmetic.
- If two prefix sums give the same remainder when divided by `k`, their difference is divisible by `k`.
- Store the first index of each remainder in a HashMap.
- If the same remainder appears again with index difference ≥ 2 → good subarray found.

### Algorithm
1. Initialize HashMap with `(0 → -1)` to handle subarrays starting at index 0.
2. Maintain a running prefix sum.
3. For each element:
    - Compute `mod = prefixSum % k`.
    - If `mod < 0`, adjust with `mod += k` (to normalize negatives).
4. If `mod` already exists in map:
    - Check if `(i - map.get(mod) >= 2)`.
    - If true → return true.
5. Otherwise, store `(mod → i)` in map.
6. If no valid subarray found, return false.

⏱️ Time Complexity: **O(n)**  
📦 Space Complexity: **O(k)**

---

## 🧠 Golden Memory Trick
- **Modulo Trick**: Same remainder → difference divisible by `k`.
- **map.put(0, -1)**: Ensures subarrays starting at index 0 are considered.
- **Main Condition**:  

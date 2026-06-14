# Maximum Product Subarray

## Problem statement
Given an integer array `nums`, find the contiguous subarray (containing at least one number) that has the **largest product**, and return that product.

**Simple view:** instead of sum, now we care about the product of consecutive elements. Negative numbers and zeros make this trickier than the sum version.

---

## Brute Force Approach

### Idea
Check every possible contiguous subarray, compute its product, and track the maximum.

### Algorithm (conceptual steps)
1. Initialize `maxProd` to the smallest possible value.
2. For each start index `i`:
    - Initialize `product = 1`.
    - For each end index `j` from `i` onward:
        - Multiply `product *= nums[j]`.
        - Update `maxProd` if `product` is larger.
3. Return `maxProd`.

### Complexity
- **Time:** O(n²)
- **Space:** O(1)

### When useful
- Small arrays
- Teaching and correctness validation

---

## Optimal Approach (Prefix–Suffix Trick)

### Core insight
- Products behave differently than sums because of **negative numbers** and **zeros**.
- A negative product can become positive if multiplied by another negative later.
- To handle this, scan from both directions (prefix left→right and suffix right→left) and track the maximum product seen.

### Algorithm (conceptual steps)
1. Initialize `prefix = 1`, `suffix = 1`, and `maxProd = -∞`.
2. Traverse the array from left to right:
    - If `prefix == 0`, reset to 1.
    - Multiply `prefix *= nums[i]`.
    - Update `maxProd` with `prefix`.
3. Traverse the array from right to left:
    - If `suffix == 0`, reset to 1.
    - Multiply `suffix *= nums[n-1-i]`.
    - Update `maxProd` with `suffix`.
4. Return `maxProd`.

### Why it works
- Resetting at zero ensures subarrays restart after zeros.
- Considering both prefix and suffix ensures negative numbers are handled correctly (a negative prefix might become positive when extended from the other side).

### Complexity
- **Time:** O(n)
- **Space:** O(1)

---

## Comparison Table

| Attribute        | Brute Force | Prefix–Suffix Optimal |
|------------------|-------------|-----------------------|
| Time Complexity  | O(n²)       | O(n)                  |
| Space Complexity | O(1)        | O(1)                  |
| Core Idea        | Try all subarrays | Track prefix & suffix products |
| Use Case         | Teaching, validation | Production, large inputs |

---

## Dry Run Example
Array: `[2, 3, -2, 4]`
- Brute force checks all subarrays.
- Prefix–suffix scan finds maximum product = `6` (subarray `[2,3]`).

Array: `[-2, 0, -1]`
- Brute force: max product = `0`.
- Prefix–suffix: resets at zero, finds max product = `0`.

---

## Learning Checklist (DSA Concepts)
- [Prefix–suffix scanning](ca://s?q=Prefix_suffix_scanning_in_arrays) for handling negatives and zeros
- [Greedy resets](ca://s?q=Greedy_resets_in_array_algorithms) when encountering zeros
- [Dynamic programming view](ca://s?q=Dynamic_programming_for_maximum_product_subarray): track max and min product ending at each index
- [Complexity analysis](ca://s?q=Time_space_complexity_analysis_examples) tradeoffs
- [Edge cases](ca://s?q=Maximum_product_subarray_edge_cases): zeros, negatives, single element arrays

---

## Memorization Tricks
- **Phrase:** “Negative × Negative = Positive — so check both ends.”
- **Visualization:** imagine scanning from both sides with two running products; reset when hitting zero.
- **Relation to sum problem:** similar to Kadane’s, but trickier because of sign flips.

---

## Notes for Future You
- Filename: `maximum-product-subarray.md`
- Commit message: `docs: add Maximum Product Subarray explanations`
- Keep this file code‑free; add your Java implementation separately in your package.

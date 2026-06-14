# Maximum Subarray Sum

## Problem statement
Given an array of integers `nums`, find the contiguous subarray (containing at least one element) whose sum is maximum and return that sum.

**Simple view:** choose a continuous slice of the array whose total is larger than any other slice.

---

## Brute Force Approach

### Idea
Check every possible contiguous subarray and track the maximum sum.

### Algorithm (conceptual steps)
1. Initialize `max_sum` to the smallest possible value.
2. For each start index `i`:
    - Initialize a running `sum = 0`.
    - For each end index `j` from `i` onward:
        - Add `nums[j]` to `sum`.
        - Update `max_sum` if `sum` is larger.
3. Return `max_sum`.

### Complexity
- **Time:** O(n²)
- **Space:** O(1)

### When useful
- Small arrays
- Teaching and correctness validation

---

## Optimal Approach (Kadane’s Algorithm)

### Core insight
Maintain the best sum ending at the current position. If the running sum becomes negative, discard it — starting fresh is always better.

### Algorithm (conceptual steps)
1. Initialize `maxSum` to the first element, `currentSum = 0`.
2. For each element `x`:
    - Add `x` to `currentSum`.
    - Update `maxSum` if `currentSum` is greater.
    - If `currentSum` < 0, reset `currentSum = 0`.
3. Return `maxSum`.

### Complexity
- **Time:** O(n)
- **Space:** O(1)

### Why it works
Negative running sums reduce future totals; discarding them ensures optimality.

---

## Comparison Table

| Attribute        | Brute Force | Kadane Optimal |
|------------------|-------------|----------------|
| Time Complexity  | O(n²)       | O(n)           |
| Space Complexity | O(1)        | O(1)           |
| Core Idea        | Try all subarrays | Drop negatives, keep best running sum |
| Use Case         | Teaching, validation | Production, large inputs |

---

## Dry Run Example
Array: `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`
- Brute force: checks all subarrays.
- Kadane: running sum resets when negative.
- Result: maximum sum = `6` for subarray `[4, -1, 2, 1]`.

---

## Learning Checklist (DSA Concepts)
- [Prefix sums](ca://s?q=Explain_prefix_sums) and reusing partial sums
- [Greedy algorithms](ca://s?q=Learn_greedy_algorithms) and local vs global optimum
- [Dynamic programming](ca://s?q=Dynamic_programming_in_arrays) view: `dp[i]` = max sum ending at `i`
- [Complexity analysis](ca://s?q=Time_and_space_complexity_analysis) tradeoffs
- [Edge cases](ca://s?q=Maximum_subarray_edge_cases): all negatives, single element, overflow
- [Dry tracing](ca://s?q=Dry_run_tracing_examples) to build intuition

---

## Memorization Tricks
- **Phrase:** “If the running sum is negative, toss it.”
- **Visualization:** imagine carrying a bucket of sum; if it leaks below zero, empty it and start fresh.
- **Prefix sum relation:** max subarray = max difference between two prefix sums.
- **Practice:** implement brute force first, then Kadane for speed.

---


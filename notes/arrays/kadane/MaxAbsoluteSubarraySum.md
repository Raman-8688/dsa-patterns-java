# Maximum Absolute Subarray Sum

## Problem Statement

Given an integer array `nums`, return the maximum absolute sum of any subarray.

The absolute sum of a subarray is defined as:

```text
|sum(subarray)|
```

where `|x|` represents the absolute value of `x`.

A subarray must be contiguous.

---

## Examples

### Example 1

Input:

```text
nums = [1, -3, 2, 3, -4]
```

Output:

```text
5
```

Explanation:

Possible subarrays:

```text
[2, 3]      → sum = 5
[-3, 2, 3]  → sum = 2
[-3]        → sum = -3
[-3, 2]     → sum = -1
```

Absolute sums:

```text
|5| = 5
|-3| = 3
|-1| = 1
```

Maximum absolute sum:

```text
5
```

---

### Example 2

Input:

```text
nums = [-2, -1, -3]
```

Output:

```text
6
```

Explanation:

Subarray:

```text
[-2, -1, -3]
```

Sum:

```text
-6
```

Absolute Sum:

```text
|-6| = 6
```

---

# Brute Force Approach

## Idea

Generate every possible subarray.

For each subarray:

1. Calculate its sum.
2. Take the absolute value.
3. Update the maximum absolute sum.

---

## Algorithm

1. Initialize:

   ```text
   maxSum = 0
   ```

2. For each starting index:

    * Initialize `current = 0`.

3. Extend the subarray one element at a time:

    * Add the current element to `current`.

    * Compute:

      ```text
      absoluteSum = |current|
      ```

    * Update:

      ```text
      maxSum = max(maxSum, absoluteSum)
      ```

4. Return `maxSum`.

---

## Time Complexity

```text
O(N²)
```

Two nested loops generate all possible subarrays.

---

## Space Complexity

```text
O(1)
```

No extra data structures are used.

---

# Optimal Approach

## Observation

We need:

```text
Maximum Absolute Sum
=
Maximum of |subarray sum|
```

Absolute value means both large positive sums and large negative sums are important.

That means we need to find:

```text
Largest Positive Subarray Sum
```

and

```text
Smallest (Most Negative) Subarray Sum
```

because:

```text
|max positive|
=
positive

|max negative|
=
absolute value of negative
```

Therefore:

```text
Answer
=
max(
    Maximum Subarray Sum,
    |Minimum Subarray Sum|
)
```

---

# Key Insight

Suppose:

```text
Maximum Subarray Sum = 7

Minimum Subarray Sum = -10
```

Then:

```text
Absolute Maximum

=
max(7, |-10|)

=
max(7, 10)

=
10
```

So we only need two Kadane's Algorithms.

---

# Kadane for Maximum Sum

Find:

```text
Largest Subarray Sum
```

Example:

```text
nums = [1, -3, 2, 3, -4]

Maximum Subarray:

[2, 3]

Sum = 5
```

---

# Inverse Kadane for Minimum Sum

Find:

```text
Smallest (Most Negative) Subarray Sum
```

Example:

```text
nums = [1, -3, 2, 3, -4]

Minimum Subarray:

[-4]

Sum = -4
```

---

# Final Formula

The maximum absolute subarray sum is:

```text
Answer
=
max(
    Maximum Subarray Sum,
    |Minimum Subarray Sum|
)
```

or,

```text
Answer
=
max(maxSubArray, abs(minSubArray))
```

---

# Why This Works

Absolute value treats positive and negative values equally.

Example:

```text
7  → |7|  = 7

-7 → |-7| = 7
```

Therefore:

The answer can only come from:

* The largest positive subarray sum.
* The most negative subarray sum.

No other subarray can produce a larger absolute value.

---

# Edge Cases

## All Positive Numbers

Example:

```text
nums = [2, 3, 4]
```

Maximum Subarray:

```text
9
```

Minimum Subarray:

```text
2
```

Answer:

```text
9
```

---

## All Negative Numbers

Example:

```text
nums = [-2, -1, -3]
```

Maximum Subarray:

```text
-1
```

Minimum Subarray:

```text
-6
```

Answer:

```text
max(-1, |-6|)

=

6
```

---

## Mixed Numbers

Example:

```text
nums = [1, -3, 2, 3, -4]
```

Maximum Subarray:

```text
5
```

Minimum Subarray:

```text
-4
```

Answer:

```text
max(5, 4)

=

5
```

---

# Overall Algorithm

1. Find the maximum subarray sum using Kadane's Algorithm.
2. Find the minimum subarray sum using inverse Kadane's Algorithm.
3. Take the absolute value of the minimum subarray sum.
4. Return:

   ```text
   max(maxSubArray, abs(minSubArray))
   ```

---

# Complexity Analysis

## Time Complexity

```text
O(N)
```

Reason:

* Kadane Maximum → O(N)
* Kadane Minimum → O(N)

Overall:

```text
O(N)
```

---

## Space Complexity

```text
O(1)
```

Only a few variables are used.

---

# Interview Explanation

If an interviewer asks how you solved this problem:

"I noticed that the maximum absolute sum can come from either a very large positive subarray sum or a very large negative subarray sum.

Using Kadane's Algorithm, I found the maximum subarray sum.

Using an inverse version of Kadane's Algorithm, I found the minimum subarray sum.

Since the absolute value of the minimum sum could be larger than the maximum positive sum, I compared both values and returned the larger one.

This gives an O(N) time and O(1) space solution."

---

# Pattern Recognition

This problem teaches an important Kadane variation:

```text
Need largest positive sum?
→ Kadane Maximum

Need most negative sum?
→ Inverse Kadane

Need maximum absolute sum?
→ Combine both
```

This pattern is frequently used in interviews and advanced Kadane problems.

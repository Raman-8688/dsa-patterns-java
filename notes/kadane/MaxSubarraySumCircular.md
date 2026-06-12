# Circular Subarray Maximum Sum

## Problem Statement

Given a circular integer array `nums`, return the maximum possible sum of a non-empty subarray.

A circular array means the element after the last index is the first element of the array.

Example:

```
Input:  [5, -3, 5]
Output: 10
```

Explanation:

```
Normal Maximum Subarray:
[5, -3, 5] = 7

Circular Maximum Subarray:
Take the first and last elements:
5 + 5 = 10
```

---

# Brute Force Approach

## Idea

Generate every possible subarray starting from each index.

Since the array is circular, use modulo (`%`) to wrap around to the beginning.

For each starting index:

* Start forming subarrays.
* Keep adding elements.
* Update the maximum sum obtained.

---

## Algorithm

1. Initialize `maxSum` as negative infinity.
2. For each index `i` from `0` to `n-1`:

    * Initialize `currentSum = 0`.
    * For `j` from `0` to `n-1`:

        * Add:

          ```
          nums[(i + j) % n]
          ```
        * Update:

          ```
          maxSum = max(maxSum, currentSum)
          ```
3. Return `maxSum`.

---

## Time Complexity

```
O(N²)
```

## Space Complexity

```
O(1)
```

---

# Optimal Approach

## Observation

The answer can come from two cases.

### Case 1: Normal Maximum Subarray

The maximum subarray lies completely inside the array without wrapping.

Example:

```
nums = [1, -2, 3, 4]

Maximum Sum = 7

Subarray = [3, 4]
```

This can be found using Kadane's Algorithm.

---

### Case 2: Circular Maximum Subarray

The maximum subarray wraps around the end of the array.

Example:

```
nums = [5, -3, 5]

Circular Subarray:
[5] + [5]

Answer = 10
```

Instead of finding the circular subarray directly, think differently.

The circular subarray consists of:

```
Entire Array
−
Minimum Sum Subarray
```

Visualization:

```
[ Maximum Circular Part ]
= Entire Array − Middle Minimum Part
```

Example:

```
nums = [5, -3, 5]

Total Sum = 7

Minimum Subarray = -3

Circular Sum

= Total Sum − Minimum Subarray
= 7 − (-3)
= 10
```

---

# Final Formula

Maximum Circular Sum is:

```
max(
    Normal Maximum Sum,
    Total Sum − Minimum Subarray Sum
)
```

That is,

```
Answer = max(maxNormal, circularSum)
```

where

```
circularSum = totalSum − minSubArray
```

---

# Important Edge Case

## All Elements Are Negative

Example:

```
nums = [-3, -2, -5]
```

Normal Maximum Sum:

```
-2
```

Total Sum:

```
-10
```

Minimum Subarray:

```
-10
```

Circular Sum:

```
-10 − (-10)
= 0
```

But this is invalid because we must choose at least one element.

The correct answer is:

```
-2
```

Therefore, before calculating the circular answer:

```
If maxNormal < 0,
return maxNormal.
```

---

# Overall Algorithm

1. Find the normal maximum subarray sum using Kadane's Algorithm.

2. If the normal maximum is negative, return it immediately.

3. Find the minimum subarray sum using inverse Kadane.

4. Calculate the total array sum.

5. Compute:

   ```
   circularSum = totalSum − minSubArray
   ```

6. Return:

   ```
   max(maxNormal, circularSum)
   ```

---

# Complexity Analysis

## Time Complexity

```
O(N)
```

Reason:

* Kadane Maximum → O(N)
* Kadane Minimum → O(N)
* Total Sum → O(N)

Overall:

```
O(N)
```

---

## Space Complexity

```
O(1)
```

No extra data structures are used.

---

# Interview Explanation

If an interviewer asks how you solved this problem:

"I observed that the answer can either be a normal maximum subarray or a circular maximum subarray.

The normal maximum is obtained using Kadane's Algorithm.

For the circular case, instead of finding it directly, I noticed that the circular maximum can be formed by removing the minimum subarray from the total array sum.

Therefore, the answer becomes the maximum of:

* Normal Maximum Subarray Sum
* Total Sum − Minimum Subarray Sum

I also handled the all-negative edge case separately because the circular formula incorrectly produces zero in that scenario.

This gives an O(N) time and O(1) space solution."

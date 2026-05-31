# Subarray With K Distinct Integers

## Pattern
Sliding Window + HashMap

## Problem
Count the number of continuous subarrays having exactly K distinct integers.

## Input
nums = [1,2,1,2,3]

k = 2

## Output
7

## Valid Subarrays
[1,2]
[1,2,1]
[1,2,1,2]
[2,1]
[2,1,2]
[1,2]
[2,3]

## Main Observation
Directly counting exactly K distinct elements is difficult.

But counting at most K distinct elements is easy using sliding window.

So:

exactly K = atMost(K) - atMost(K - 1)

## Brute Force Approach

### Idea
Generate every possible subarray.

Use HashMap to count distinct elements.

If distinct count is exactly K:
increase count.

If distinct count becomes greater than K:
break.

### Algorithm
1. Start i from 0 to n-1.
2. Create empty HashMap.
3. Start j from i to n-1.
4. Add nums[j] into map.
5. If map size == k, count++.
6. If map size > k, break.

### Time Complexity
O(n²)

### Space Complexity
O(k)

## Optimized Sliding Window Approach

### Formula
exactly K distinct = atMost(K) - atMost(K - 1)

## Why This Formula Works

`atMost(K)` contains all subarrays having:

- 1 distinct
- 2 distinct
- ...
- K distinct

`atMost(K - 1)` contains all subarrays having:

- 1 distinct
- 2 distinct
- ...
- K - 1 distinct

So after subtraction, only exactly K distinct subarrays remain.

## atMost Algorithm

1. Start left = 0.
2. Use right pointer to expand window.
3. Store frequency in HashMap.
4. If map size > k:
   shrink from left.
5. Add window size to count:

right - left + 1

## Why count += right - left + 1

For every right index, all subarrays ending at right inside valid window are valid.

Example:

nums = [1,2,1]

k = 2

At right = 2:

window = [1,2,1]

Valid subarrays ending at right:

[1]
[2,1]
[1,2,1]

Count = window size.

## Dry Run

nums = [1,2,1,2,3]

k = 2

Answer:

exactly 2 = atMost(2) - atMost(1)

atMost(2) = 12

atMost(1) = 5

exactly 2 = 7

## Time Complexity
O(n)

Because each pointer moves at most n times.

## Space Complexity
O(k)

HashMap stores frequencies.

## Golden Rule
Exactly K is hard.

At most K is easy.

exactly K = atMost(K) - atMost(K - 1)

## Memory Trick
Exactly = AtMost current - AtMost previous

## Backtracking Style Thinking
If we try to count exactly K directly using one window, it becomes confusing because shrinking may remove valid subarrays.

Instead, count broad groups:

atMost(K)

Then remove smaller group:

atMost(K - 1)

Only exactly K remains.

## Common Mistakes
- Forgetting the formula
- Removing wrong key from HashMap
- Writing `if(nums[left] == 0)` instead of checking map value
- Using if instead of while when map size > k
- Not understanding why window size is added

## What I Learned
- Exactly K problems can be solved using atMost logic.
- HashMap tracks distinct count.
- Sliding window works when condition is at most K.
- Formula-based thinking is very useful in interviews.
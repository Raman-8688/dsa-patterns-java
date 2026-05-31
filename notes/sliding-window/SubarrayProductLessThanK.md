# Subarray Product Less Than K

## Pattern
Sliding Window

## Problem
Given an array of positive integers and integer k, count the number of continuous subarrays where product is less than k.

## Input
nums = [10, 5, 2, 6]

k = 100

## Output
8

## Valid Subarrays
[10]
[5]
[2]
[6]
[10,5]
[5,2]
[2,6]
[5,2,6]

## Main Observation
We need continuous subarrays.

Product must be less than k.

So we can maintain a window where:

product < k

## Brute Force Approach

### Idea
Generate every possible subarray and calculate product.

### Algorithm
1. Start from every index i.
2. Set product = 1.
3. Expand j from i to end.
4. Multiply nums[j].
5. If product < k, count it.
6. If product >= k, break.

### Time Complexity
O(n²)

### Why Break Is Used
All numbers are positive.

If product already becomes greater than or equal to k,
adding more numbers will only increase product.

So we can stop checking further for that starting index.

## Optimized Sliding Window Approach

### Idea
Use left and right pointers.

Expand right and multiply current number.

If product becomes invalid:

product >= k

shrink from left by dividing nums[left].

## Golden Rule
Expand by multiplying right.

Shrink by dividing left.

## How To Identify This Pattern
Use Sliding Window when:
- Need continuous subarray
- Need count of valid subarrays
- Window condition can become valid/invalid
- Positive numbers allow shrinking logic

## Algorithm
1. If k <= 1, return 0.
2. Start left = 0.
3. Start product = 1.
4. Move right from 0 to n - 1.
5. Multiply product by nums[right].
6. While product >= k:
    - divide product by nums[left]
    - move left
7. Add right - left + 1 to count.

## Why count += right - left + 1

For every right pointer,
all subarrays ending at right are valid.

Example:

nums = [10, 5, 2, 6]

At right = 2, valid window is:

[5, 2]

Valid subarrays ending at right are:

[2]
[5, 2]

Count = window size = right - left + 1

## Dry Run

nums = [10, 5, 2, 6]

k = 100

right = 0

product = 10

count += 1

Subarray:
[10]

right = 1

product = 10 * 5 = 50

count += 2

Subarrays:
[5], [10,5]

right = 2

product = 50 * 2 = 100

Invalid.

Divide by nums[left] = 10

product = 10

left = 1

count += 2

Subarrays:
[2], [5,2]

right = 3

product = 10 * 6 = 60

count += 3

Subarrays:
[6], [2,6], [5,2,6]

Total = 8

## Why k <= 1 Returns 0

All nums are positive integers.

Minimum product is at least 1.

So product less than 1 is impossible.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Product window:

multiply right

divide left

count window size

## Backtracking Style Thinking
Brute force recalculates product for many repeated subarrays.

Sliding window reuses product.

When product becomes too large,
we remove old values from left instead of starting again.

## Common Mistakes
- Forgetting k <= 1 condition
- Adding only 1 instead of right - left + 1
- Using this approach when negative numbers exist
- Not understanding why divide left works

## What I Learned
- Sliding window works well with positive numbers.
- Count of valid subarrays ending at right equals window size.
- Product-based window uses multiply and divide.
# Maximum Sum Subarray of Size K

## Pattern
Sliding Window

## Problem
Find the maximum sum of any continuous subarray of size K.

## Input
nums = [2, 1, 5, 1, 3, 2]
k = 3

## Output
9

## How To Identify This Pattern
Use Sliding Window when:
- Subarray is continuous
- Window size is fixed
- Need max/min/sum/count
- We can add new element and remove old element

## Golden Rule
For fixed-size window:

Add new element.
Remove old element.

## Algorithm
1. Find sum of first K elements.
2. Store it as maxSum.
3. Move window one step at a time.
4. Add new right element.
5. Remove left old element.
6. Update maxSum.

## Dry Run

nums = [2, 1, 5, 1, 3, 2]
k = 3

First window:

2 + 1 + 5 = 8

maxSum = 8

Move window:

Add 1, remove 2

windowSum = 8 + 1 - 2 = 7

Move window:

Add 3, remove 1

windowSum = 7 + 3 - 1 = 9

maxSum = 9

Move window:

Add 2, remove 5

windowSum = 9 + 2 - 5 = 6

Final answer = 9

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Fixed window means:

Slide = add right + remove left

## Backtracking Style Thinking
Brute force checks every K-size subarray separately.

Example:

[2,1,5], [1,5,1], [5,1,3]

But most elements are repeated in the next window.

So instead of recalculating full sum,
we reuse previous sum.

## Common Mistakes
- Recalculating sum every time
- Forgetting to subtract nums[right - k]
- Confusing fixed window with variable window
- Starting second loop from wrong index

## What I Learned
- Sliding window avoids repeated work.
- Fixed-size window is simple: add one, remove one.
- This pattern is useful for max/min/sum of continuous subarrays.
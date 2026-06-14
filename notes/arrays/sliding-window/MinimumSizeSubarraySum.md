# Minimum Size Subarray Sum

## Pattern
Sliding Window

## Problem
Find the minimum length of a continuous subarray whose sum is greater than or equal to target.

## Input
target = 7

nums = [2,3,1,2,4,3]

## Output
2

## Main Observation
We need:
- continuous subarray
- minimum length
- sum condition

This is classic Sliding Window.

## Brute Force Approach

### Idea
Generate every possible subarray.

Calculate sum.

If sum >= target:
update minimum length.

### Algorithm
1. Start from every index i.
2. Expand j from i to end.
3. Add nums[j] to sum.
4. If sum >= target:
   update minimum length.
   break.

### Why Break Is Used
Once condition becomes valid:
larger window only increases length.

So current smallest window for that starting point is already found.

## Time Complexity
O(n²)

## Optimized Sliding Window Approach

### Main Idea
Maintain a window whose sum is tracked continuously.

When sum becomes valid:

sum >= target

try shrinking window from left to find smaller valid window.

## Golden Rule
Expand right to increase sum.

Shrink left to minimize valid window.

## How To Identify Sliding Window
Use Sliding Window when:
- continuous subarray
- longest/minimum window
- condition based sum
- window can expand and shrink

## Algorithm
1. Start left = 0.
2. Move right pointer.
3. Add nums[right] to sum.
4. While sum >= target:
    - update minimum length
    - subtract nums[left]
    - move left

## Dry Run

target = 7

nums = [2,3,1,2,4,3]

Window:

[2,3,1,2]

sum = 8

Valid.

length = 4

Shrink from left:

[3,1,2]

sum = 6

Invalid.

Expand again:

[3,1,2,4]

sum = 10

Shrink:

[1,2,4]

sum = 7

length = 3

Shrink:

[2,4]

sum = 6

Invalid.

Expand:

[2,4,3]

sum = 9

Shrink:

[4,3]

sum = 7

length = 2

Final answer = 2

## Why While Loop Is Important

Suppose:

sum = 15

target = 7

Removing only one element may still keep sum valid.

We must continue shrinking until window becomes invalid.

That is why:

while(sum >= target)

is required.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Expand for validity.

Shrink for minimum size.

## Backtracking Style Thinking
Brute force restarts sum calculation for every subarray.

Sliding window reuses previous sum.

Instead of restarting:
we remove old elements from left.

## Common Mistakes
- Using if instead of while
- Forgetting to update minLength before shrinking
- Returning Integer.MAX_VALUE
- Confusing longest window with minimum window

## What I Learned
- Sliding window can optimize subarray problems.
- Shrinking logic is important for minimum window problems.
- Reusing previous sum avoids repeated calculations.
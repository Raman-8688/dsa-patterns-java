# Max Consecutive Ones III

## Pattern
Sliding Window

## Problem
Find the maximum number of consecutive 1s after flipping at most K zeroes.

## Input
nums = [1,1,1,0,0,0,1,1,1,1,0]

k = 2

## Output
6

## Main Observation
We can flip at most K zeroes.

So valid window means:

zeroCount <= k

## Brute Force Approach

### Idea
Check every possible subarray.

For every subarray:
- count zeroes
- if zeroCount <= k:
  update maxLength

### Algorithm
1. Start outer loop from every index.
2. Start inner loop from current index.
3. Count zeroes.
4. If zeroCount > k:
   break.
5. Update maxLength.

### Time Complexity
O(n²)

### Why Brute Force Is Bad
Many repeated subarrays are checked again and again.

## Optimized Sliding Window Approach

### Main Idea
Maintain a valid window where:

zeroCount <= k

If zeroCount becomes greater than k:
shrink window from left.

## Golden Rule
Expand right.

If condition breaks:
shrink left.

## How To Identify Sliding Window
Use Sliding Window when:
- continuous subarray
- longest/maximum/minimum
- condition based window
- expand and shrink possible

## Algorithm
1. Start left = 0.
2. Traverse using right pointer.
3. Count zeroes.
4. If zeroCount > k:
   move left until valid.
5. Update maxLength.

## Dry Run

nums = [1,1,1,0,0,0,1,1,1,1,0]

k = 2

Window:

[1,1,1,0,0]

zeroCount = 2

Valid.

Expand more:

[1,1,1,0,0,0]

zeroCount = 3

Invalid.

Move left until zeroCount becomes 2 again.

Continue.

Maximum valid window length = 6

## Why While Loop Is Needed

Suppose:

zeroCount = 4
k = 2

One left movement may not be enough.

We must continue shrinking until:

zeroCount <= k

That is why:

while(zeroCount > k)

is required.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Expand right.

Shrink left when invalid.

## Backtracking Style Thinking

Suppose:

[1,1,0,0,0]

k = 1

When third zero comes:
window becomes invalid.

Instead of restarting:
we remove elements from left.

This avoids repeated work.

## Common Mistakes
- Using if instead of while
- Forgetting zeroCount decrement
- Returning wrong window size
- Not updating maxLength correctly

## What I Learned
- Sliding window avoids repeated subarray checking.
- Valid window condition is important.
- Expand and shrink logic is the core idea.
- This converts O(n²) brute force into O(n).
# Two Sum II - Two Pointers

## Pattern
Two Pointers

## Problem
Given a sorted array and target value, find two numbers whose sum equals target.

## Input
numbers = [2, 7, 11, 15]
target = 9

## Output
[2, 7]

## Main Observation
The array is already sorted.

This is the biggest hint for using two pointers.

## How To Identify This Pattern
Use Two Pointers when:
- Array is sorted
- Need pair/triplet
- Need sum comparison
- Need O(n) optimization

## Golden Rule
If current sum is smaller:
Move left pointer.

If current sum is bigger:
Move right pointer.

Because array is sorted.

## Algorithm
1. Start left pointer at beginning.
2. Start right pointer at end.
3. Calculate sum.
4. If sum == target → answer found.
5. If sum < target → increase left.
6. If sum > target → decrease right.

## Dry Run

numbers = [2, 7, 11, 15]
target = 9

left = 0
right = 3

2 + 15 = 17
Too large.
Move right.

2 + 11 = 13
Too large.
Move right.

2 + 7 = 9
Found answer.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Small sum → move left
Large sum → move right

## Why This Works
Because the array is sorted.

Moving left increases sum.
Moving right decreases sum.

## Common Mistake
This approach works only for sorted arrays.

If array is unsorted:
- Use HashMap approach instead.

## Backtracking Style Thinking
Suppose sum becomes too large.

Example:

2 + 15 = 17

We know:
- left side numbers are smaller
- right side numbers are larger

So keeping 15 can never help.

Therefore we move right backward.

## What I Learned
- Sorted arrays often indicate two pointers.
- We can reduce O(n²) brute force to O(n).
- Pointer movement depends on current sum.
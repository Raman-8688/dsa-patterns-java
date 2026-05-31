# Move Zeroes

## Pattern
Two Pointers

## Problem
Given an integer array, move all zeroes to the end while maintaining the order of non-zero elements.

## Input
nums = [0, 1, 0, 3, 12]

## Output
[1, 3, 12, 0, 0]

## What We Need To Do
We need to keep all non-zero numbers in the same order and move all zeroes to the end.

## How To Identify This Pattern
Use Two Pointers when:
- Array needs in-place modification
- We need to move/filter elements
- One pointer scans the array
- Another pointer tracks the correct position

## Golden Rule
Fast pointer searches for useful elements.  
Slow pointer tells where to place them.

## Algorithm
1. Create `slow = 0`.
2. Run `fast` from index `0` to end.
3. If `nums[fast] != 0`, place it at `nums[slow]`.
4. Increase `slow`.
5. After all non-zero values are placed, fill remaining positions with `0`.

## Dry Run

Input:

[0, 1, 0, 3, 12]

Initial:

slow = 0

fast = 0 → nums[fast] = 0  
Ignore it.

fast = 1 → nums[fast] = 1  
Place 1 at nums[slow].  
Array becomes [1, 1, 0, 3, 12]  
slow = 1

fast = 2 → nums[fast] = 0  
Ignore it.

fast = 3 → nums[fast] = 3  
Place 3 at nums[slow].  
Array becomes [1, 3, 0, 3, 12]  
slow = 2

fast = 4 → nums[fast] = 12  
Place 12 at nums[slow].  
Array becomes [1, 3, 12, 3, 12]  
slow = 3

Now fill remaining places with zero:

Final:

[1, 3, 12, 0, 0]

## Code Logic
The first loop moves all non-zero values to the front.

The second loop fills the remaining positions with zero.

## Why We Are Not Swapping
Swapping is also possible, but here we use overwrite method:
- First collect non-zero values
- Then fill remaining positions with zero

This is simple and clean.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Fast finds.  
Slow fills.

## Backtracking Example
Suppose input is:

[0, 0, 1]

If we only move 1 to front, array becomes:

[1, 0, 1]

The last 1 is old duplicate value.  
So we must go back from `slow` position and fill remaining values with 0.

That is why second while loop is required.

## What I Learned
- Two pointers can be used for in-place array modification.
- `fast` pointer is used for scanning.
- `slow` pointer is used for placement.
- After moving valid elements, remaining positions must be cleaned.
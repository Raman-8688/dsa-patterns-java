# Trapping Rain Water

## Pattern
Two Pointers

## Problem
Given heights of bars, calculate how much rain water can be trapped.

## Input
height = [0,1,0,2,1,0,1,3,2,1,2,1]

## Output
6

## Formula
Water at any index:

min(left max, right max) - current height

## Main Observation
Water depends on the smaller boundary.

For every index:
- left side maximum wall
- right side maximum wall

The smaller wall decides how much water can stay.

## Brute Force Idea
For every index:
1. Find maximum height on left side.
2. Find maximum height on right side.
3. Water = min(leftMax, rightMax) - height[i]

Time Complexity: O(n²)

## Optimized Two Pointer Idea
Instead of calculating leftMax and rightMax for every index again and again, maintain them while moving pointers.

## How To Identify This Pattern
Use this pattern when:
- Water/area depends on left and right boundary
- Need max/min boundary comparison
- Brute force checks left side and right side repeatedly
- Need O(n) optimization

## Golden Rule
Move the side with smaller maximum boundary.

If leftMax < rightMax:
calculate water from left side.

Otherwise:
calculate water from right side.

## Algorithm
1. Set left = 0.
2. Set right = n - 1.
3. Set leftMax = height[left].
4. Set rightMax = height[right].
5. While left < right:
    - If leftMax < rightMax:
        - move left
        - update leftMax
        - add leftMax - height[left]
    - Else:
        - move right
        - update rightMax
        - add rightMax - height[right]

## Dry Run

height = [0,1,0,2,1,0,1,3,2,1,2,1]

left = 0
right = 11

leftMax = 0
rightMax = 1

leftMax < rightMax

Move left.

left = 1
leftMax = max(0,1) = 1
water = 1 - 1 = 0

Now continue.

Whenever current height is smaller than max boundary,
water gets trapped.

## Why This Works
If leftMax < rightMax, then left side is the limiting boundary.

We already have a bigger wall on right side.

So water at left side depends only on leftMax.

Same logic applies for right side.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Water is controlled by the smaller wall.

Smaller max side is safe to calculate.

## Backtracking Style Thinking
Suppose:

leftMax = 2
rightMax = 5

Since right side already has a taller wall,
left side decides water.

So we can safely calculate water from left.

No need to search again.

## Common Mistakes
- Confusing height[left] with leftMax
- Moving wrong pointer
- Forgetting to update max before adding water
- Using O(n²) brute force in interview
- Not understanding why smaller max side moves

## What I Learned
- Trapping water depends on boundaries.
- Two pointers can replace repeated left/right scans.
- `leftMax` and `rightMax` help remember best walls.
- The smaller boundary decides trapped water.
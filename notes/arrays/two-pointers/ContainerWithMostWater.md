# Container With Most Water

## Pattern
Two Pointers

## Problem
Given heights of vertical lines, find two lines that can hold the maximum water.

## Input
height = [1,8,6,2,5,4,8,3,7]

## Output
49

## Formula
area = min(left height, right height) * width

width = right - left

## Main Observation
Water depends on the smaller height.

Even if one side is very tall, the smaller side decides the water level.

## How To Identify This Pattern
Use Two Pointers when:
- Need best pair from array
- Pair depends on left and right values
- Need maximum/minimum result
- Brute force checks all pairs

## Golden Rule
Always move the pointer with the smaller height.

## Why Move Smaller Height?
Area depends on:

1. width
2. minimum height

Width is already maximum at start.

When we move a pointer, width decreases.

So to get better area, we must try to increase the smaller height.

## Algorithm
1. Put left at start.
2. Put right at end.
3. Calculate area.
4. Update maxArea.
5. Move the pointer with smaller height.
6. Continue until left < right.

## Dry Run

height = [1,8,6,2,5,4,8,3,7]

left = 0 → height 1  
right = 8 → height 7

area = min(1,7) * 8 = 8

Left is smaller, move left.

left = 1 → height 8  
right = 8 → height 7

area = min(8,7) * 7 = 49

maxArea = 49

Continue checking, but 49 remains maximum.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
Water level is controlled by the shorter wall.

Move the shorter wall.

## Backtracking Style Thinking
Suppose:

left height = 1  
right height = 7

Area is limited by 1.

If we move right, width decreases and height is still limited by 1.

So moving right cannot help.

Therefore move left.

## Common Mistakes
- Moving taller pointer
- Using nested loops
- Forgetting width calculation
- Thinking taller wall controls water

## What I Learned
- Two pointers can optimize pair-based problems.
- Start from widest range.
- Move the weaker/smaller side.
- The smaller height decides the container capacity.
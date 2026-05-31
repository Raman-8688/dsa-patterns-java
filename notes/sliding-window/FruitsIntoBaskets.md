# Fruits Into Baskets

## Pattern
Sliding Window + HashMap

## Problem
Find the longest continuous subarray containing at most 2 different types of fruits.

## Input
fruits = [1, 2, 1]

## Output
3

## Main Observation
We have only 2 baskets.

That means we can collect at most 2 fruit types in a continuous range.

So this becomes:

Longest subarray with at most 2 distinct elements.

## How To Identify This Pattern
Use this pattern when:
- Need longest continuous subarray
- Condition depends on number of distinct elements
- Need at most K different types
- HashMap can store frequency

## Golden Rule
Expand right.

If distinct count becomes more than 2:

shrink left.

## Algorithm
1. Create left = 0.
2. Create HashMap to store fruit frequency.
3. Move right pointer.
4. Add fruits[right] into map.
5. If map size > 2:
    - reduce fruits[left] frequency
    - remove it if frequency becomes 0
    - move left
6. Update max length.

## Dry Run

fruits = [1, 2, 1]

right = 0

map = {1=1}

window = [1]

max = 1

right = 1

map = {1=1, 2=1}

window = [1,2]

max = 2

right = 2

map = {1=2, 2=1}

window = [1,2,1]

max = 3

Final answer = 3

## Why HashMap Is Used
HashMap stores:

fruit type → count

It helps us know:
- how many fruit types are inside window
- when to remove fruit type from window

## Time Complexity
O(n)

## Space Complexity
O(1)

Because maximum 3 fruit types are temporarily stored.

## Memory Trick
2 baskets = at most 2 distinct values.

## Backtracking Style Thinking
Suppose window becomes:

[1, 2, 3]

Now we have 3 types.

But only 2 baskets are allowed.

So we remove fruits from left until only 2 types remain.

## Common Mistakes
- Forgetting to remove fruit when count becomes 0
- Using if instead of while
- Thinking this is normal counting problem
- Not identifying it as longest subarray with at most 2 distinct

## What I Learned
- Basket problem is actually a distinct element sliding window problem.
- HashMap is useful for frequency tracking.
- Longest valid window is updated after shrinking.
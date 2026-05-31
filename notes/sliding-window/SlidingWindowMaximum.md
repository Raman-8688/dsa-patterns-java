# Sliding Window Maximum

## Pattern
Sliding Window + Deque

## Problem
Find the maximum element in every window of size K.

## Input
nums = [1,3,-1,-3,5,3,6,7]

k = 3

## Output
[3,3,5,5,6,7]

## Main Observation
We need maximum from every continuous window of size K.

Brute force checks every window separately.

Optimized approach keeps useful maximum candidates using Deque.

## Brute Force Approach

### Idea
For every window of size K:
- scan all K elements
- find maximum
- store it

### Algorithm
1. Start i from 0 to n-k.
2. For every i, scan from i to i+k.
3. Find max.
4. Store max in result.

### Time Complexity
O(n * k)

## Optimized Approach

### Data Structure
Deque stores indexes, not values.

Why indexes?
Because we need to know:
- whether an element is outside the current window
- value comparison using nums[index]

## Golden Rule
Deque should maintain indexes of elements in decreasing value order.

Front of deque always contains index of maximum element.

## Algorithm
1. Create empty deque.
2. Traverse right from 0 to n-1.
3. Remove indexes from front if they are outside current window.
4. Remove indexes from back while their values are smaller than nums[right].
5. Add right index to deque.
6. Once first window is complete, store nums[deque.front] in result.

## Why Remove From Front
If:

deque.peekFirst() <= right - k

that index is outside the current window.

So remove it.

## Why Remove From Back
If current element is bigger than elements at deque back,
those smaller elements can never become maximum.

So remove them.

## Dry Run

nums = [1,3,-1]

k = 3

right = 0

deque = [0]

right = 1

nums[1] = 3 is greater than nums[0] = 1

remove 0

deque = [1]

right = 2

nums[2] = -1 is smaller than nums[1] = 3

deque = [1,2]

First window complete.

max = nums[deque front] = nums[1] = 3

## Time Complexity
O(n)

Each index is added once and removed once.

## Space Complexity
O(k)

Deque stores indexes from current window.

## Memory Trick
Deque front = current window maximum.

Back removes weak elements.

Front removes expired elements.

## Backtracking Style Thinking
In brute force, every window recalculates maximum.

Example:

[1,3,-1] and [3,-1,-3]

Both share elements.

Optimized approach remembers useful candidates instead of recalculating.

## Common Mistakes
- Storing values instead of indexes
- Forgetting to remove expired index
- Using `<` and `<=` incorrectly for window boundary
- Adding result before window size reaches K
- Not understanding deque decreasing order

## What I Learned
- Some sliding window problems need extra data structure.
- Deque helps maintain maximum efficiently.
- Front gives answer, back removes useless elements.
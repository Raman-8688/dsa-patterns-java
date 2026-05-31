# Max Consecutive Ones

## Pattern
Sliding Window / Continuous Sequence Tracking

## Problem
Find the maximum number of consecutive 1s in the array.

## Input
[1, 1, 0, 1, 1, 1]

## Output
3

## Main Observation
We only care about continuous 1s.

Whenever 0 appears:
the sequence breaks.

## How To Identify This Pattern
Use this type of logic when:
- Need continuous sequence
- Need longest streak
- Sequence breaks on condition
- Need max length/count

## Golden Rule
Increase count while condition is valid.

Reset when condition breaks.

## Algorithm
1. Create currentCount = 0.
2. Traverse array.
3. If element is 1:
   increment currentCount.
4. If element is 0:
   update maxCount.
   reset currentCount.
5. Return maximum count.

## Dry Run

nums = [1,1,0,1,1,1]

currentCount = 0
maxCount = 0

1 → currentCount = 1
1 → currentCount = 2
0 → maxCount = 2, reset currentCount
1 → currentCount = 1
1 → currentCount = 2
1 → currentCount = 3

Final answer = 3

## Why Final Math.max Is Needed

Suppose array ends with 1s:

[1,1,1]

Loop never enters else block.

So maxCount never updates.

That is why we do:

Math.max(maxCount, currentCount)

at the end.

## Time Complexity
O(n)

## Space Complexity
O(1)

## Memory Trick
1 continues sequence

0 breaks sequence

## Backtracking Style Thinking
Suppose:

[1,1,1]

No zero appears.

Without final comparison:
answer becomes 0.

So after traversal,
we must compare last sequence also.

## Common Mistakes
- Forgetting final max comparison
- Resetting incorrectly
- Confusing count with index

## What I Learned
- Continuous sequence problems often use counters.
- Reset logic is important.
- Final pending sequence must also be checked.
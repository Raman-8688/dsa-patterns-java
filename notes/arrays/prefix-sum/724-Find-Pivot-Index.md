# Find Pivot Index

## Pattern

Prefix Sum

## Problem

Given an integer array `nums`, return the pivot index.

A pivot index is an index where:

Left Sum = Right Sum

If no pivot index exists, return `-1`.

---

## Example

### Input

```java
nums = [1,7,3,6,5,6]
```

### Output

```java
3
```

### Explanation

```text
Left Sum  = 1 + 7 + 3 = 11
Right Sum = 5 + 6 = 11
```

---

# Brute Force Approach

## Idea

For every index:

* Calculate left sum
* Calculate right sum
* Compare both

If equal, return index.

---

## Algorithm

1. Iterate every index `i`.
2. Calculate left sum from `0` to `i-1`.
3. Calculate right sum from `i+1` to `n-1`.
4. If both sums are equal, return `i`.
5. Return `-1`.

Golden Algorithm
1. Calculate Total Sum.

2. Initialize Left Sum = 0

3. Traverse array:

       Right Sum =
       Total Sum
       - Left Sum
       - Current Element

       If Left Sum == Right Sum
             return current index

       Add current element into Left Sum

4. Return -1

---

## Time Complexity

```text
O(n²)
```

## Space Complexity

```text
O(1)
```

---

# Optimized Prefix Sum Approach

## Main Observation

Repeatedly calculating left and right sums is expensive.

Instead:

* Calculate total array sum once.
* Maintain running left sum.
* Derive right sum using a formula.

---

## Golden Formula

```text
RightSum = TotalSum - LeftSum - nums[i]
```

---

## Golden Algorithm

1. Calculate total array sum.
2. Initialize `leftSum = 0`.
3. Traverse the array.
4. Compute:

```text
rightSum = totalSum - leftSum - nums[i]
```

5. If:

```text
leftSum == rightSum
```

return current index.

6. Update:

```text
leftSum += nums[i]
```

7. Continue traversal.
8. Return `-1`.

---

# Dry Run

```java
nums = [1,7,3,6,5,6]

Total Sum = 28
```

| Index | LeftSum | Current | RightSum |
| ----- | ------- | ------- | -------- |
| 0     | 0       | 1       | 27       |
| 1     | 1       | 7       | 20       |
| 2     | 8       | 3       | 17       |
| 3     | 11      | 6       | 11       |

```text
LeftSum == RightSum

11 == 11
```

Answer:

```text
3
```

---

# How To Identify Prefix Sum Problems

Look for words like:

* Left Sum
* Right Sum
* Running Sum
* Range Sum
* Equilibrium Index
* Continuous Sum

Ask yourself:

```text
Can I reuse previous sums
instead of recalculating them?
```

If YES →

Think Prefix Sum.

---

# Golden Interview Trick

Remember:

```text
Left is known,
Right can be derived.
```

Formula:

```text
RightSum =
TotalSum
-
LeftSum
-
CurrentElement
```

This eliminates nested loops.

---

# Time Complexity

```text
O(n)
```

---

# Space Complexity

```text
O(1)
```

---

# Common Mistakes

* Recalculating left and right sums every time.
* Forgetting to subtract current element.
* Updating left sum before checking condition.
* Missing the pivot at index 0.

---

# What I Learned

* Prefix Sum converts O(n²) into O(n).
* Running sums help avoid repeated calculations.
* Total Sum can be used to derive Right Sum.
* Many interview questions use the same Prefix Sum idea.

---

# Revision Notes (10 Seconds)

Pattern:

```text
Prefix Sum
```

Formula:

```text
RightSum =
TotalSum
-
LeftSum
-
nums[i]
```

Check:

```text
LeftSum == RightSum
```

Update:

```text
LeftSum += nums[i]
```

Complexity:

```text
Time  : O(n)
Space : O(1)
```

---

# Memory Trick

```text
Know Total Once
Track Left Always
Derive Right Instantly
```

Whenever you see:

Left Sum == Right Sum

Immediately think:

Prefix Sum + Running Left Sum.

# K-th Largest Subarray Sum

## Problem Statement

Given an integer array `arr` and an integer `k`, return the K-th largest sum among all possible contiguous subarrays.

A subarray must be contiguous.

---

# Examples

## Example 1

Input:

```text
arr = [3, 2, 1]
k = 2
```

All possible subarray sums:

```text
[3]       → 3
[3,2]     → 5
[3,2,1]   → 6
[2]       → 2
[2,1]     → 3
[1]       → 1
```

Sorted in descending order:

```text
6, 5, 3, 3, 2, 1
```

2nd Largest:

```text
5
```

Output:

```text
5
```

---

## Example 2

Input:

```text
arr = [2, 6, 4, 1]
k = 3
```

Subarray sums:

```text
[2]         → 2
[2,6]       → 8
[2,6,4]     → 12
[2,6,4,1]   → 13
[6]         → 6
[6,4]       → 10
[6,4,1]     → 11
[4]         → 4
[4,1]       → 5
[1]         → 1
```

Sorted:

```text
13, 12, 11, 10, 8, 6, 5, 4, 2, 1
```

3rd Largest:

```text
11
```

Output:

```text
11
```

---

# Brute Force Approach

## Idea

Generate every possible subarray sum.

Store all sums.

Sort them in descending order.

Return the K-th element.

---

# Algorithm

## Step 1

Generate all subarrays.

Choose every starting index.

```text
i = 0 to n-1
```

---

## Step 2

Extend the subarray.

For each starting index:

```text
j = i to n-1
```

Keep adding elements to form subarray sums.

---

## Step 3

Store each sum.

Example:

```text
arr = [3,2,1]

Generated sums:

3
5
6
2
3
1
```

---

## Step 4

Sort the sums in descending order.

Example:

```text
6, 5, 3, 3, 2, 1
```

---

## Step 5

Return:

```text
sums[k-1]
```

because indexing starts from zero.

---

# Complexity Analysis (Brute Force)

Total subarrays:

```text
N × (N+1) / 2
```

≈

```text
O(N²)
```

Sorting:

```text
O((N²) log(N²))
```

which becomes:

```text
O(N² log N)
```

---

# Space Complexity

```text
O(N²)
```

because all subarray sums are stored.

---

# Optimal Approach

## Observation

We do NOT need all subarray sums sorted.

We only need:

```text
K-th Largest Sum
```

or

```text
Top K Largest Sums
```

Therefore, instead of storing everything:

Use a Min Heap of size K.

---

# Key Idea

Maintain only the K largest sums seen so far.

If the heap size exceeds K:

Remove the smallest element.

At the end:

The root of the Min Heap is the K-th largest sum.

---

# Prefix Sum Optimization

To calculate subarray sums efficiently:

Use Prefix Sums.

---

# Prefix Sum Definition

Prefix sum at index i:

```text
prefix[i]
=
sum of elements from 0 to i-1
```

Example:

```text
arr = [3,2,1]
```

Prefix Array:

```text
prefix[0] = 0
prefix[1] = 3
prefix[2] = 5
prefix[3] = 6
```

Thus:

```text
prefix = [0,3,5,6]
```

---

# Computing Subarray Sum

Subarray:

```text
i ..... j
```

Sum:

```text
prefix[j+1] − prefix[i]
```

Example:

```text
arr = [3,2,1]

Find sum of [2,1].

i = 1
j = 2

prefix[3] − prefix[1]

6 − 3

= 3
```

---

# Algorithm

## Step 1

Compute Prefix Sum Array.

---

## Step 2

Create a Min Heap.

Purpose:

```text
Store only K largest sums.
```

---

## Step 3

Generate all subarray sums.

For every:

```text
i = 0 to n−1
j = i to n−1
```

Calculate:

```text
sum = prefix[j+1] − prefix[i]
```

Insert into heap.

---

## Step 4

If heap size exceeds K:

Remove:

```text
heap.poll()
```

which removes the smallest element.

---

## Step 5

After processing all sums:

Return:

```text
heap.peek()
```

because the smallest element among the Top K largest sums is exactly the K-th largest sum.

---

# Why Min Heap Works

Suppose:

```text
K = 3
```

Current Top 3 sums:

```text
13, 12, 11
```

Min Heap:

```text
11
12
13
```

Root:

```text
11
```

which is the:

```text
3rd Largest Sum
```

Now suppose a new sum arrives:

```text
15
```

Heap becomes:

```text
11,12,13,15
```

Size exceeds K.

Remove smallest:

```text
11
```

Remaining:

```text
12,13,15
```

Again:

Root becomes:

```text
12
```

which is now the 3rd largest.

Thus, the heap continuously maintains the Top K largest sums.

---

# Complexity Analysis (Optimal)

Generating all subarrays:

```text
O(N²)
```

Each heap insertion/removal:

```text
O(log K)
```

Therefore:

```text
O(N² log K)
```

---

# Space Complexity

Prefix Array:

```text
O(N)
```

Heap:

```text
O(K)
```

Overall:

```text
O(N + K)
```

---

# Interview Explanation

If an interviewer asks:

"How did you solve this problem?"

You can say:

"I first observed that there are O(N²) subarrays.

The brute-force approach generates all subarray sums, stores them, sorts them, and returns the K-th largest sum.

To optimize, I realized that I only need the Top K largest sums instead of all sums.

I used Prefix Sums to calculate each subarray sum in O(1) time.

Then, I maintained a Min Heap of size K.

Whenever the heap size exceeded K, I removed the smallest element.

After processing all subarrays, the root of the heap represented the K-th largest subarray sum.

This reduced the complexity from O(N² log N) to O(N² log K)."

---

# Pattern Recognition

This problem teaches an important interview pattern:

```text
Need all subarray sums?
→ Prefix Sum

Need Top K elements?
→ Min Heap

Need K-th Largest Subarray Sum?
→ Prefix Sum + Min Heap
```

---

# Comparison

Brute Force:

```text
Generate all sums
↓
Store all sums
↓
Sort descending
↓
Return K-th element
```

Complexity:

```text
Time  : O(N² log N)
Space : O(N²)
```

---

Optimal:

```text
Prefix Sum
↓
Generate subarray sums
↓
Maintain Min Heap of size K
↓
Heap Root = K-th Largest
```

Complexity:

```text
Time  : O(N² log K)
Space : O(N + K)
```

---

# Takeaway

Whenever you hear:

```text
"K-th Largest"
"Top K"
"K-th Smallest"
```

immediately think:

```text
Heap
```

Whenever you hear:

```text
"Subarray Sum"
"Range Sum"
```

immediately think:

```text
Prefix Sum
```

Combining these two patterns gives the solution to the K-th Largest Subarray Sum problem.

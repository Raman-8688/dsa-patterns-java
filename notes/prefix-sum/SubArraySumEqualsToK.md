# SubArray Sum Equals K

## Question

Given an integer array `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals `k`.

---

# Pattern

**Prefix Sum + HashMap**

Whenever you hear:

* Count Subarrays
* Subarray Sum = K
* Continuous Sum Problems

Think:

```text
Prefix Sum + HashMap
```

---

# Brute Force Thinking

Generate every possible subarray.

For each subarray:

1. Calculate sum
2. If sum == k
3. Increase count

### Brute Force Algorithm

```text
Start from each index
Extend subarray one by one
Keep calculating sum
If sum becomes k
Count++
```

### Complexity

```text
Time  : O(n²)
Space : O(1)
```

---

# Optimization Thinking

Instead of recalculating every subarray sum,

Store previous Prefix Sums.

### Key Observation

If:

```text
Current Prefix Sum = P
```

Need:

```text
Subarray Sum = K
```

Then check:

```text
P - K
```

If already seen before,

A valid subarray exists.

---

# Main Formula

```text
Current Prefix Sum - Previous Prefix Sum = K
```

Therefore:

```text
Previous Prefix Sum = Current Prefix Sum - K
```

This is the entire logic.

---

# Example 1

```text
nums = [1,1,1]
k = 2
```

Prefix Sums:

```text
1
2
3
```

When Prefix Sum = 2

Need:

```text
2 - 2 = 0
```

Found.

Count = 1

When Prefix Sum = 3

Need:

```text
3 - 2 = 1
```

Found.

Count = 2

Answer:

```text
2
```

---

# Example 2

```text
nums = [1,2,3]
k = 3
```

Prefix Sums:

```text
1
3
6
```

When Prefix Sum = 3

Need:

```text
3 - 3 = 0
```

Found.

Count = 1

When Prefix Sum = 6

Need:

```text
6 - 3 = 3
```

Found.

Count = 2

Answer:

```text
2
```

---

# Why map.put(0,1)?

Very Important.

It represents:

```text
Empty Prefix Sum before array starts
```

Without it,

Subarrays starting from index 0 will be missed.

---

# Optimized Algorithm

```text
Create HashMap

Store:
0 → 1

prefixSum = 0
count = 0

For every number:

    Add to prefixSum

    Check:
    prefixSum - k

    If found:
        count += frequency

    Store current prefixSum frequency
```

---

# Complexity

```text
Time  : O(n)
Space : O(n)
```

---

# Remembering Trick

Think like this:

```text
Current Money = 100
Need Profit = 30

Ask:

What old value should exist?

100 - 30 = 70
```

Same here:

```text
Current Prefix Sum = P

Need Sum = K

Look for:

P - K
```

Just remember:

```text
Current - Required
```

or

```text
PrefixSum - K
```

---

# What I Learned

✓ Prefix Sum Concept

✓ HashMap Frequency Storage

✓ Counting Subarrays Efficiently

✓ PrefixSum - K Pattern

✓ O(n²) → O(n) Optimization

✓ One of the most important Prefix Sum interview patterns

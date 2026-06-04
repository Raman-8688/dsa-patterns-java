# Product of Array Except Self

## Pattern

Prefix Product

## Problem

Given an integer array `nums`, return an array `answer` such that:

```text
answer[i]
=
Product of all elements in nums
except nums[i]
```

You must solve it without using division and in O(n) time.

---

# Example

### Input

```java
nums = [1,2,3,4]
```

### Output

```java
[24,12,8,6]
```

### Explanation

```text
Index 0:
2 × 3 × 4 = 24

Index 1:
1 × 3 × 4 = 12

Index 2:
1 × 2 × 4 = 8

Index 3:
1 × 2 × 3 = 6
```

---

# Question Explanation

For every index:

```text
Take all elements
except current element
and multiply them.
```

Example:

```java
nums = [1,2,3,4]
```

For index 2:

```text
1 × 2 × 4 = 8
```

Current element 3 is excluded.

---

# Brute Force Approach

## Idea

For every index:

* Traverse complete array.
* Skip current index.
* Multiply remaining elements.

---

## Algorithm

1. Create result array.
2. For every index i:

    * product = 1
    * Traverse whole array.
    * Skip i.
    * Multiply remaining elements.
3. Store product in result[i].
4. Return result.

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

# Optimized Prefix Product Approach

## Main Observation

For every index:

```text
Answer =
Left Product
×
Right Product
```

Example:

```java
nums = [1,2,3,4]
```

For index 2:

```text
Left Product

1 × 2 = 2

Right Product

4

Answer

2 × 4 = 8
```

Instead of recalculating products every time:

```text
Store Left Product

Calculate Right Product
while traversing from right.
```

---

# Golden Formula

```text
Answer[i]

=
Product Of Left Side
×

Product Of Right Side
```

---

# Optimized Algorithm

## Step 1

Store left products.

```java
res[0] = 1
```

Because:

```text
Nothing exists on left side.
```

Then:

```java
res[i] = res[i-1] * nums[i-1]
```

Meaning:

```text
Current left product

=
Previous left product
×
Previous element
```

---

## Step 2

Calculate right products.

Start:

```java
rightProduct = 1
```

Because:

```text
Nothing exists on right side
of last element.
```

Traverse from right to left.

For every index:

```java
res[i] = res[i] * rightProduct
```

Then update:

```java
rightProduct *= nums[i]
```

---

# Understanding Your Code

## First Loop

```java
res[0] = 1;

for(int i=1;i<n;i++){
    res[i]=res[i-1]*nums[i-1];
}
```

Purpose:

```text
Store Left Products.
```

Example:

```java
nums = [1,2,3,4]
```

Result becomes:

```java
[1,1,2,6]
```

Explanation:

```text
Index 0 -> 1

Index 1 -> 1

Index 2 -> 1×2 = 2

Index 3 -> 1×2×3 = 6
```

---

## Second Loop

```java
int rightpro = 1;

for(int r=n-1;r>=0;r--){
    res[r]=res[r]*rightpro;
    rightpro*=nums[r];
}
```

Purpose:

```text
Multiply Right Product.
```

---

# Dry Run

```java
nums = [1,2,3,4]
```

After first loop:

```java
res = [1,1,2,6]
```

rightpro = 1

---

r = 3

```text
res[3] = 6 × 1 = 6

rightpro = 1 × 4 = 4
```

---

r = 2

```text
res[2] = 2 × 4 = 8

rightpro = 4 × 3 = 12
```

---

r = 1

```text
res[1] = 1 × 12 = 12

rightpro = 12 × 2 = 24
```

---

r = 0

```text
res[0] = 1 × 24 = 24
```

Final:

```java
[24,12,8,6]
```

---

# Why This Works

For every index:

```text
Left Product
already stored in res.

Right Product
stored in rightpro.

Multiply both.

Done.
```

No need to calculate products repeatedly.

---

# Backtracking Style Thinking

Suppose:

```java
nums = [1,2,3,4]
```

For index 2:

Brute Force thinks:

```text
Start again.

Multiply:
1 × 2 × 4
```

Optimized thinking:

```text
Left Product already known.

1 × 2 = 2

Right Product already known.

4

Answer = 2 × 4
```

Instead of recomputing:

```text
Reuse previous work.
```

This is the core optimization idea.

---

# How To Identify This Pattern

Whenever you see:

```text
Product Except Self

Left Side Product

Right Side Product

Without Division
```

Think:

```text
Prefix Product
+
Suffix Product
```

---

# Golden Rule

```text
Answer[i]

=
Left Product
×
Right Product
```

Always remember:

```text
Build Left First

Multiply Right Later
```

---

# Unforgettable Trick

Imagine every index says:

```text
I don't want my own value.

Give me everything
on my left

and everything
on my right.
```

So:

```text
Current Element

❌ Excluded

Left Product

✅ Included

Right Product

✅ Included
```

---

# Common Mistakes

1. Using division.
2. Including current element.
3. Incorrect initialization.

```java
res[0] = 1
rightpro = 1
```

4. Traversing second loop from left to right.

Must be:

```java
Right → Left
```

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

(Excluding output array)

---

# What I Learned

* Prefix Product is similar to Prefix Sum.
* Store left contribution first.
* Calculate right contribution later.
* Reuse previous computations.
* Many interview questions use Prefix + Suffix technique.

---

# Revision Notes (10 Seconds)

Pattern:

```text
Prefix Product
```

Formula:

```text
Answer

=
Left Product
×
Right Product
```

Steps:

```text
Store Left Products

Traverse Right

Multiply Right Product
```

Complexity:

```text
Time  : O(n)

Space : O(1)
```

---

# Memory Trick

```text
Left First

Right Later

Multiply Both

Answer Ready
```

Whenever you hear:

```text
Product Except Self
```

Immediately think:

```text
Prefix Product
+
Suffix Product
```

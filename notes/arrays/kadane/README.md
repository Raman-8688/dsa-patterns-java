# ⚡ Kadane's Algorithm & Variations - Quick Revision Guide

---

## 🚀 Module Core Motive & Blueprint
**Kadane's Algorithm** is a dynamic programming technique used to find the maximum sum of a contiguous subarray in linear $O(n)$ time.

**Core Advantage:** Eliminates $O(n^2)$ brute-force subarray checks by making a greedy decision at each element: *Should I extend the existing subarray sum, or discard it and start fresh from the current element?*

---

## 🔍 How to Instantly Identify Kadane Questions
Look for these keywords and triggers in the problem statement:
- **"Maximum sum of a contiguous subarray"**.
- **"Maximum product of a contiguous subarray"**.
- **"Circular array maximum subarray sum"**.
- **"Absolute maximum sum"**.
- Key intuition: Negative numbers exist; carrying a negative running sum hurts future elements.

---

## ⚡ Golden Formulas & Universal Templates

### Standard Kadane Formula
$$\text{currSum} = \max(\text{nums}[i], \text{currSum} + \text{nums}[i])$$
$$\text{maxSum} = \max(\text{maxSum}, \text{currSum})$$

### Circular Subarray Maximum Formula
$$\text{MaxCircular} = \max(\text{MaxKadane}, \text{TotalSum} - \text{MinKadane})$$
*(Special case: If all elements are negative, return `MaxKadane` directly).*

---

## 🧠 Question-by-Question Flash Recap

### 1. Maximum Subarray Sum (LeetCode 53)
- **Note Link:** [MaximumSubArray.md](file:///d:/dsa-patterns-java/notes/arrays/kadane/MaximumSubArray.md)
- **Core Logic:** Track `currSum = 0`, `maxSum = Integer.MIN_VALUE`. For each `num`: `currSum = max(num, currSum + num)`, `maxSum = max(maxSum, currSum)`.
- **Golden Rule:** If `currSum < 0`, reset `currSum = 0` (discard past baggage).
- **🔑 Mental Trick:** **Cut Off Financial Debt** — If your running total goes into negative debt, drop it immediately! Starting fresh with `num` is always better than dragging negative debt along.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 2. Maximum Product Subarray (LeetCode 152)
- **Note Link:** [MaximumProductSubarray.md](file:///d:/dsa-patterns-java/notes/arrays/kadane/MaximumProductSubarray.md)
- **Core Logic:** Track both `maxProd` and `minProd`. When encountering a negative number `num < 0`, swap `maxProd` and `minProd`. Update `maxProd = max(num, maxProd * num)` and `minProd = min(num, minProd * num)`.
- **Golden Rule:** Multiplying by a negative flips maximum to minimum and minimum to maximum.
- **🔑 Mental Trick:** **Negative Flip Swap** — A large negative number multiplied by another negative becomes a HUGE positive! Keep track of the worst negative so you're ready when a negative multiplier arrives.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 3. Maximum Subarray Sum Circular (LeetCode 918)
- **Note Link:** [MaxSubarraySumCircular.md](file:///d:/dsa-patterns-java/notes/arrays/kadane/MaxSubarraySumCircular.md)
- **Core Logic:** Run Standard Kadane to find `maxKadane`. Run Min-Kadane to find `minKadane`. Compute `totalSum`.
  - Wrapped max sum = `totalSum - minKadane`.
  - Return `max(maxKadane, totalSum - minKadane)` (handle all-negative case where `maxKadane < 0`).
- **Golden Rule:** Wrapped subarray sum = Total Sum $-$ Minimum Subarray Sum in middle.
- **🔑 Mental Trick:** **Donut Subarray** — The max sum either stays inside the middle (Standard Kadane) or wraps around the edges (Total array minus the minimum chunk in the middle).
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 4. Maximum Absolute Sum of Any Subarray (LeetCode 1749)
- **Note Link:** [MaxAbsoluteSubarraySum.md](file:///d:/dsa-patterns-java/notes/arrays/kadane/MaxAbsoluteSubarraySum.md)
- **Core Logic:** Run standard Kadane for `maxSum` (most positive) and inverted Kadane for `minSum` (most negative). Return `max(maxSum, abs(minSum))`.
- **Golden Rule:** Maximum absolute sum is either the most positive sum or the absolute value of the most negative sum.
- **🔑 Mental Trick:** **Two Extreme Peaks** — Find the highest mountain peak (max positive sum) and the deepest ocean trench (min negative sum), then take the largest magnitude.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 5. Kth Largest Subarray Sum
- **Note Link:** [KthLargestSubarraySum.md](file:///d:/dsa-patterns-java/notes/arrays/kadane/KthLargestSubarraySum.md)
- **Core Logic:** Compute prefix sum array. Calculate all subarray sums using prefix differences. Maintain a **Min-Heap** of size $K$. Return `heap.peek()`.
- **Golden Rule:** Min-Heap of size $K$ retains the top $K$ largest elements at any time.
- **🔑 Mental Trick:** **V.I.P. Bouncer Queue** — Keep a min-heap door for $K$ guests. Any newcomer larger than `heap.peek()` kicks out the smallest guest to maintain the top $K$ subarray sums.
- **Complexity:** Time: $O(n^2 \log k)$ | Space: $O(k)$

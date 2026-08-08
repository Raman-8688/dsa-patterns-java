# 🪟 Sliding Window Pattern - Quick Revision Guide

---

## 🚀 Module Core Motive & Blueprint
The **Sliding Window** pattern maintains a dynamic or fixed subarray/substring boundary (`[left, right]`) over a sequence to process contiguous element segments efficiently.

**Core Advantage:** Transforms brute-force $O(n^2)$ contiguous subarray checks into $O(n)$ linear processing by re-using accumulated state (sum, counts, frequency map) as the window slides.

---

## 🔍 How to Instantly Identify Sliding Window Questions
Look for these keywords and triggers in the problem statement:
- Contiguous sequence: **"Subarray"** (for arrays) or **"Substring"** (for strings).
- Optimization goal: **"Maximum / Minimum length"**, **"Maximum / Minimum sum"**, **"Count of subarrays satisfying condition"**.
- Constraints: **"At most K distinct elements"**, **"Sum $\ge K$"**, **"Exact K unique items"**.

---

## ⚡ Golden Formulas & Universal Templates

### Template 1: Fixed Window Size $K$
```java
int windowSum = 0, maxSum = 0;
for (int right = 0; right < nums.length; right++) {
    windowSum += nums[right]; // Add incoming element
    
    if (right >= k - 1) {
        maxSum = Math.max(maxSum, windowSum);
        windowSum -= nums[right - (k - 1)]; // Remove outgoing element
    }
}
```

### Template 2: Variable Window Size (Dynamic Window)
```java
int left = 0;
for (int right = 0; right < nums.length; right++) {
    // 1. Expand window: add nums[right] to state
    
    // 2. Shrink window while condition is violated
    while (/* window is invalid */) {
        // remove nums[left] from state
        left++;
    }
    
    // 3. Update answer (max length, min length, or count)
    ans = Math.max(ans, right - left + 1);
}
```

### Template 3: Exact $K$ Distinct Elements Formula
$$\text{Subarrays with Exact } K = \text{Subarrays with At Most }(K) - \text{Subarrays with At Most }(K - 1)$$

---

## 🧠 Question-by-Question Flash Recap

### 1. Maximum Sum Subarray of Size K
- **Note Link:** [MaximumSumSubarrayOfSizeK.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/MaximumSumSubarrayOfSizeK.md)
- **Core Logic:** Fixed window of length $k$. Maintain `windowSum`. When `right >= k - 1`, record max sum and subtract `nums[right - k + 1]`.
- **Golden Rule:** `windowSum = windowSum + incoming - outgoing`.
- **🔑 Mental Trick:** **Conveyor Belt** — Adding an item at the front automatically drops off the oldest item at the back.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 2. Max Consecutive Ones (I & III)
- **Note Links:** [MaxConsecutiveOnes.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/MaxConsecutiveOnes.md) & [MaxConsecutiveOnesIII.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/MaxConsecutiveOnesIII.md)
- **Core Logic (III):** Expand `right`. If `nums[right] == 0`, increment `zeroCount`. While `zeroCount > k`, shrink `left` (if `nums[left] == 0`, `zeroCount--`; `left++`). Update `maxLen = max(maxLen, right - left + 1)`.
- **Golden Rule:** Window is valid as long as `zeroCount <= k`.
- **🔑 Mental Trick:** **Wildcard Pass Allowance** — You have `k` free passes to flip zeros. If zero debt exceeds `k`, push `left` until debt is back within budget.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 3. Minimum Size Subarray Sum
- **Note Link:** [MinimumSizeSubarraySum.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/MinimumSizeSubarraySum.md)
- **Core Logic:** Expand `right` adding `nums[right]` to `sum`. While `sum >= target`, update `minLen = min(minLen, right - left + 1)` and shrink window (`sum -= nums[left]; left++`).
- **Golden Rule:** Shrink eagerly while valid to capture the absolute minimal valid window length.
- **🔑 Mental Trick:** **Rubber Band Squeeze** — Stretch right until target sum is met, then squeeze left as tight as possible while staying above target.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 4. Subarray Product Less Than K
- **Note Link:** [SubarrayProductLessThanK.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/SubarrayProductLessThanK.md)
- **Core Logic:** Expand `right` multiplying `product *= nums[right]`. While `product >= k`, shrink `left` (`product /= nums[left]; left++`). Number of valid subarrays ending at `right` is `right - left + 1`.
- **Golden Rule:** Every new element `right` in a valid window `[left, right]` adds `(right - left + 1)` new contiguous subarrays ending at `right`.
- **🔑 Mental Trick:** **Tail Subarray Counting** — Including `nums[right]` introduces `[right]`, `[right-1, right]`, ..., `[left..right]`, totaling `right - left + 1` new subarrays.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 5. Fruit Into Baskets (At Most 2 Distinct Types)
- **Note Link:** [FruitsIntoBaskets.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/FruitsIntoBaskets.md)
- **Core Logic:** Use HashMap to store character/fruit frequencies. Expand `right`. If `map.size() > 2`, shrink `left` by decrementing frequency of `nums[left]` and removing from map if count reaches 0. Update `maxLen = max(maxLen, right - left + 1)`.
- **Golden Rule:** `map.size()` must stay $\le 2$.
- **🔑 Mental Trick:** **Two Hands, Two Baskets** — You only have 2 hands for 2 fruit types. When a 3rd fruit appears, discard fruits from the left until one basket becomes completely empty.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$ (map stores at most 3 elements)

---

### 6. Subarrays with K Distinct Integers
- **Note Link:** [SubarrayWithKDistinctIntegers.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/SubarrayWithKDistinctIntegers.md)
- **Core Logic:** Direct sliding window for *exact* $K$ is tricky because window is non-monotonic. Compute `atMost(k) - atMost(k - 1)`.
- **Golden Rule:** $\text{Exact}(K) = \text{AtMost}(K) - \text{AtMost}(K - 1)$.
- **🔑 Mental Trick:** **Venn Diagram Subtraction** — Subtracting "Subarrays with $\le K-1$ distinct items" from "Subarrays with $\le K$ distinct items" leaves strictly subarrays with *exactly* $K$ distinct items.
- **Complexity:** Time: $O(n)$ | Space: $O(n)$

---

### 7. Sliding Window Maximum (Monotonic Queue / Deque)
- **Note Link:** [SlidingWindowMaximum.md](file:///d:/dsa-patterns-java/notes/arrays/sliding-window/SlidingWindowMaximum.md)
- **Core Logic:** Use a `ArrayDeque<Integer>` storing indices in **monotonically decreasing order** of values.
  - Remove indices smaller than `nums[right]` from back of deque.
  - Remove index from front if it falls outside window (`peekFirst() <= right - k`).
  - Add `right`. If `right >= k - 1`, `nums[peekFirst()]` is the window maximum.
- **Golden Rule:** Deque front always stores index of the maximum element in the current window.
- **🔑 Mental Trick:** **Seniority vs. Power** — Newer bigger elements eliminate older smaller elements from the deque because the older smaller ones will never get a chance to be the maximum.
- **Complexity:** Time: $O(n)$ | Space: $O(k)$

# ➕ Prefix Sum Pattern - Quick Revision Guide

---

## 🚀 Module Core Motive & Blueprint
The **Prefix Sum** pattern precomputes cumulative totals of an array up to each index (`prefix[i] = nums[0] + ... + nums[i]`).

**Core Advantage:** Answers range sum queries $sum(L, R)$ in $O(1)$ constant time, and allows finding contiguous subarrays matching a target sum $K$ in $O(n)$ time using a HashMap storing cumulative frequencies.

---

## 🔍 How to Instantly Identify Prefix Sum Questions
Look for these keywords and triggers in the problem statement:
- Range queries: **"Sum between index L and R"**, **"Subarray sum equals K"**.
- Arrays containing **negative numbers** (where sliding window fails because sum is non-monotonic).
- Divisibility/Remainders: **"Subarray sum divisible by K"**, **"Continuous subarray sum multiple of K"**.
- Balance points: **"Pivot index"**, **"Left sum equals right sum"**.

---

## ⚡ Golden Formulas & Universal Templates

### Formula 1: Range Sum Query
$$\text{Sum}(L, R) = \text{Prefix}[R] - \text{Prefix}[L - 1]$$

### Formula 2: Subarray Sum Equals $K$ (HashMap Lookup)
$$\text{CurrentPrefixSum} - \text{Target } K = \text{PreviousPrefixSum}$$
*Lookup `map.containsKey(currSum - K)` to find earlier matching prefix endpoints.*

### Formula 3: Subarray Sum Divisible by $K$ (Modulo Invariant)
$$(\text{Prefix}[R] - \text{Prefix}[L]) \pmod K = 0 \implies \text{Prefix}[R] \pmod K = \text{Prefix}[L] \pmod K$$
*Normalize negative remainders:* `rem = ((rem % k) + k) % k`.

---

## 🧠 Question-by-Question Flash Recap

### 1. Find Pivot Index (LeetCode 724)
- **Note Link:** [724-Find-Pivot-Index.md](file:///d:/dsa-patterns-java/notes/arrays/prefix-sum/724-Find-Pivot-Index.md)
- **Core Logic:** Compute `totalSum`. Iterate `i` maintaining `leftSum`. At index `i`, `rightSum = totalSum - leftSum - nums[i]`. If `leftSum == rightSum`, return `i`.
- **Golden Rule:** `leftSum == totalSum - leftSum - nums[i]`.
- **🔑 Mental Trick:** **Balance Scale Point** — Total weight on left pan must equal remaining total weight minus current pivot weight.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 2. Product of Array Except Self (LeetCode 238)
- **Note Link:** [ProductofArrayExceptSelf.md](file:///d:/dsa-patterns-java/notes/arrays/prefix-sum/ProductofArrayExceptSelf.md)
- **Core Logic:** Compute prefix products from left into `ans[]`. Then iterate backwards from right maintaining `suffixProduct`, updating `ans[i] *= suffixProduct`.
- **Golden Rule:** $\text{Result}[i] = \text{PrefixProduct}[i-1] \times \text{SuffixProduct}[i+1]$.
- **🔑 Mental Trick:** **Left Sandwich $\times$ Right Sandwich** — Every element's product is its left cumulative product multiplied by its right cumulative product (without using division!).
- **Complexity:** Time: $O(n)$ | Space: $O(1)$ extra space (output array doesn't count)

---

### 3. Subarray Sum Equals K (LeetCode 560)
- **Note Link:** [SubArraySumEqualsToK.md](file:///d:/dsa-patterns-java/notes/arrays/prefix-sum/SubArraySumEqualsToK.md)
- **Core Logic:** Maintain `currSum`. Use `HashMap<Integer, Integer>` storing `{prefixSum : frequency}` initialized with `{0 : 1}`. At each step, `count += map.getOrDefault(currSum - k, 0)`, then `map.put(currSum, map.getOrDefault(currSum, 0) + 1)`.
- **Golden Rule:** `currSum - k` gives the required prefix sum value from the past.
- **🔑 Mental Trick:** **Looking Back in History** — "How many times in history did my running total equal `currSum - k`? Each historical occurrence forms a valid subarray ending right here!"
- **Complexity:** Time: $O(n)$ | Space: $O(n)$

---

### 4. Continuous Subarray Sum (LeetCode 523)
- **Note Link:** [ContinuousSubarraySum.md](file:///d:/dsa-patterns-java/notes/arrays/prefix-sum/ContinuousSubarraySum.md)
- **Core Logic:** Track running `rem = (rem + nums[i]) % k`. Store `{remainder : first_seen_index}` in HashMap initialized with `{0 : -1}`. If `rem` seen before at index `prevIdx` and `i - prevIdx >= 2`, return `true`.
- **Golden Rule:** If two prefix sums yield the exact same remainder modulo $K$, the sum between them is a multiple of $K$.
- **🔑 Mental Trick:** **Clock Cycle Identity** — If the clock hand lands on the exact same minute mark after adding a segment of length $\ge 2$, that segment was a full multiple of $K$ hours!
- **Complexity:** Time: $O(n)$ | Space: $O(\min(n, k))$

---

### 5. Subarray Sums Divisible by K (LeetCode 974)
- **Note Link:** [SubarraySumDivisiblebyK.md](file:///d:/dsa-patterns-java/notes/arrays/prefix-sum/SubarraySumDivisiblebyK.md)
- **Core Logic:** Running `rem = (rem + nums[i]) % k`. Normalize negative remainders: `rem = ((rem % k) + k) % k`. Maintain array `count[k]` of remainder frequencies. `ans += count[rem]`, then `count[rem]++`.
- **Golden Rule:** Normalize negative remainder: `((rem % k) + k) % k`.
- **🔑 Mental Trick:** **Remainder Bucket Counting** — Every time you land on remainder `rem`, add all previous occurrences of `rem` to your total count.
- **Complexity:** Time: $O(n)$ | Space: $O(k)$

---

### 6. Matrix Block Sum (LeetCode 1314 / 2D Prefix Sum)
- **Note Link:** [MatrixBlockSumDemo.md](file:///d:/dsa-patterns-java/notes/arrays/prefix-sum/MatrixBlockSumDemo.md)
- **Core Logic:** Build 2D prefix sum grid `P[r][c]`. Sum of rectangle `(r1, c1)` to `(r2, c2)` = $P[r2][c2] - P[r1-1][c2] - P[r2][c1-1] + P[r1-1][c1-1]$.
- **Golden Rule:** Inclusion-Exclusion Principle on 2D grids.
- **🔑 Mental Trick:** **Big Rectangle minus Top & Left plus Overlap Corner** — Draw the big box from $(0,0)$, remove top strip and left strip, then add back the top-left corner that was subtracted twice!
- **Complexity:** Time: $O(m \times n)$ | Space: $O(m \times n)$

# 🎯 Two Pointers Pattern - Quick Revision Guide

---

## 🚀 Module Core Motive & Blueprint
The **Two Pointers** pattern uses two index variables (`left` and `right`) to traverse an array or sequence simultaneously—either moving towards each other from opposite ends or moving in the same direction at different speeds.

**Core Advantage:** Reduces $O(n^2)$ nested loop brute-force search to $O(n)$ linear time by leveraging order (sorted arrays) or structural invariants.

---

## 🔍 How to Instantly Identify Two Pointer Questions
Look for these keywords and triggers in the problem statement:
- Array is **sorted** (or can be sorted).
- Searching for **pairs, triplets, or subarrays** that meet a specific condition (e.g., target sum).
- In-place array modification without extra memory ($O(1)$ space requirement).
- Comparing elements from **both ends** (e.g., palindromes, maximum area containers, trapping water).

---

## ⚡ Golden Formulas & Universal Templates

### Opposite Direction Template (Sorted Arrays / Pair Matching)
```java
int left = 0, right = nums.length - 1;
while (left < right) {
    int currentSum = nums[left] + nums[right];
    if (currentSum == target) {
        // Found match!
        left++; right--;
    } else if (currentSum < target) {
        left++;  // Need larger value
    } else {
        right--; // Need smaller value
    }
}
```

### Same Direction Template (Fast & Slow Pointers / In-Place Partition)
```java
int slow = 0;
for (int fast = 0; fast < nums.length; fast++) {
    if (/* condition to keep nums[fast] */) {
        nums[slow] = nums[fast];
        slow++;
    }
}
```

---

## 🧠 Question-by-Question Flash Recap

### 1. Two Sum II (Sorted Array)
- **Note Link:** [TwoSumTwoPointers.md](file:///d:/dsa-patterns-java/notes/arrays/two-pointers/TwoSumTwoPointers.md)
- **Core Logic:** Place `left = 0`, `right = n - 1`. If `nums[left] + nums[right] == target`, return indices. If sum $< \text{target}$, `left++`. If sum $> \text{target}$, `right--`.
- **Golden Rule:** `sum < target` $\implies$ move `left` rightward; `sum > target` $\implies$ move `right` leftward.
- **🔑 Mental Trick:** **Seesaw Equilibrium** — If the seesaw is too light, step onto a heavier block on the left (`left++`). If too heavy, step down to a lighter block on the right (`right--`).
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 2. Move Zeroes
- **Note Link:** [MoveZeroes.md](file:///d:/dsa-patterns-java/notes/arrays/two-pointers/MoveZeroes.md)
- **Core Logic:** Maintain `slow` pointer for non-zero write position. Iterate `fast` pointer through array. When `nums[fast] != 0`, swap `nums[slow]` and `nums[fast]`, then increment `slow`.
- **Golden Rule:** `nums[slow]` always tracks the first zero position waiting to be swapped.
- **🔑 Mental Trick:** **Snowplow Cleaning** — `fast` searches for clean snow (non-zeroes) ahead and pushes all dirt (zeroes) behind `slow`.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 3. Sort Colors (Dutch National Flag Algorithm)
- **Note Link:** [sortColors.md](file:///d:/dsa-patterns-java/notes/arrays/two-pointers/sortColors.md)
- **Core Logic:** Partition array into three sections using 3 pointers: `low` (0s boundary), `mid` (current inspection), `high` (2s boundary).
  - If `nums[mid] == 0`: Swap `nums[low]` & `nums[mid]`, `low++`, `mid++`.
  - If `nums[mid] == 1`: `mid++`.
  - If `nums[mid] == 2`: Swap `nums[mid]` & `nums[high]`, `high--` (do NOT increment `mid`).
- **Golden Rule:** `[0..low-1] = 0`, `[low..mid-1] = 1`, `[mid..high] = unsorted`, `[high+1..n-1] = 2`.
- **🔑 Mental Trick:** **Traffic Light Sorting** — Push Red (0) to left fence, Blue (2) to right fence, and Yellow (1) stays in the middle.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 4. 3Sum
- **Note Link:** [ThreeSum.md](file:///d:/dsa-patterns-java/notes/arrays/two-pointers/ThreeSum.md)
- **Core Logic:** Sort array. Loop `i` from `0` to `n - 3`. For each `i`, run 2-pointer search (`left = i + 1`, `right = n - 1`) for `nums[left] + nums[right] == -nums[i]`. Skip duplicate elements for `i`, `left`, and `right`.
- **Golden Rule:** `a + b + c = 0` $\iff$ `b + c = -a`. Fix `a`, find pair `(b, c)`.
- **🔑 Mental Trick:** **Anchor & Search** — Anchor the first person (`i`), then run 2-pointer speed dating on the remaining sorted queue to find their balancing partners.
- **Complexity:** Time: $O(n^2)$ | Space: $O(1)$ extra space (excluding output)

---

### 5. Container With Most Water
- **Note Link:** [ContainerWithMostWater.md](file:///d:/dsa-patterns-java/notes/arrays/two-pointers/ContainerWithMostWater.md)
- **Core Logic:** Place `left = 0`, `right = n - 1`. Calculate `area = min(height[left], height[right]) * (right - left)`. Always move the pointer pointing to the **shorter line** (`if height[left] < height[right] left++ else right--`).
- **Golden Rule:** Area is bottlenecked by the shorter wall. Moving the taller wall can never increase area because width shrinks while height remains bounded by the shorter wall.
- **🔑 Mental Trick:** **Sacrifice the Bottleneck** — Always ditch the shorter side wall because keeping it gives ZERO chance of finding a bigger container.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### 6. Trapping Rain Water
- **Note Link:** [TrappingRainWater.md](file:///d:/dsa-patterns-java/notes/arrays/two-pointers/TrappingRainWater.md)
- **Core Logic:** Track `leftMax` and `rightMax`. Place `left = 0`, `right = n - 1`.
  - If `height[left] <= height[right]`:
    - If `height[left] >= leftMax`, update `leftMax = height[left]`.
    - Else `water += leftMax - height[left]`. `left++`.
  - Else:
    - If `height[right] >= rightMax`, update `rightMax = height[right]`.
    - Else `water += rightMax - height[right]`. `right--`.
- **Golden Rule:** Water trapped at index `i` = $\max(0, \min(\text{leftMax}, \text{rightMax}) - \text{height}[i])$.
- **🔑 Mental Trick:** **Squeezing Water Pockets** — Water at any bar is bounded by the lower of the two boundaries. Process whichever side has the smaller boundary wall.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

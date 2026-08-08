# 🔍 Binary Search Pattern - Quick Revision Guide

---

## 🚀 Module Core Motive & Blueprint
**Binary Search** is an optimal $O(\log n)$ search technique that halves the search space at each iteration by taking advantage of monotonic ordering (sorted order) or binary decision boundaries.

**Core Advantage:** Eliminates half of the remaining elements at every step, turning linear $O(n)$ searches into logarithmic $O(\log n)$ operations.

---

## 🔍 How to Instantly Identify Binary Search Questions
Look for these keywords and triggers in the problem statement:
- Explicit condition: **"Sorted array"**, **"Search in $O(\log n)$ time"**.
- Implicit search spaces: **"Find minimum/maximum value $x$ satisfying condition $F(x)$"** (Search space on answer).
- Rotated sorted arrays: **"Shifted/Rotated sorted array"**.
- Bound queries: **"First occurrence"**, **"Last occurrence"**, **"Ceiling"**, **"Floor"**, **"Insert position"**.

---

## ⚡ Golden Formulas & Universal Templates

### Template 1: Classic Target Search
```java
int left = 0, right = nums.length - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) return mid;
    else if (nums[mid] < target) left = mid + 1;
    else right = mid - 1;
}
return -1;
```

### Template 2: Lower Bound (First index where `nums[mid] >= target` / Ceiling)
```java
int left = 0, right = nums.length - 1, ans = -1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] >= target) {
        ans = mid;
        right = mid - 1; // Keep searching left for earlier/smaller candidate
    } else {
        left = mid + 1;
    }
}
return ans;
```

### Template 3: Upper Bound Variant (Last occurrence where `nums[mid] == target`)
```java
int left = 0, right = nums.length - 1, ans = -1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] == target) {
        ans = mid;
        left = mid + 1; // Keep searching right for later candidate
    } else if (nums[mid] < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}
return ans;
```

---

## 🧠 Question-by-Question Flash Recap

### 1. Simple Target Binary Search
- **Note Link:** [TargetBinarySearchSimple.md](file:///d:/dsa-patterns-java/notes/binary-search/clasic-binary-search/TargetBinarySearchSimple.md)
- **Core Logic:** `mid = left + (right - left) / 2`. Compare `nums[mid]` with `target`.
- **Golden Rule:** Prevent integer overflow: `mid = left + (right - left) / 2` instead of `(left + right) / 2`.
- **🔑 Mental Trick:** **Phonebook Half-Splitting** — Open right in the middle. If target name is before, throw away right half; if after, throw away left half.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 2. Search Insert Position (LeetCode 35)
- **Note Link:** [BinarySearchInsertPosition.md](file:///d:/dsa-patterns-java/notes/binary-search/clasic-binary-search/BinarySearchInsertPosition.md)
- **Core Logic:** Standard binary search. If target not found when loop terminates (`left > right`), return `left`.
- **Golden Rule:** When loop ends without exact match, `left` pointer automatically lands on the correct insertion index.
- **🔑 Mental Trick:** **Spot Pointer** — The `left` pointer is the "pusher" that lands exactly where target belongs.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 3. Square Root (LeetCode 69)
- **Note Link:** [BinarySearchSqrt.md](file:///d:/dsa-patterns-java/notes/binary-search/clasic-binary-search/BinarySearchSqrt.md)
- **Core Logic:** Search space from `1` to `x`. If `mid * mid == x`, return `mid`. If `mid <= x / mid`, store `ans = mid` and move `left = mid + 1`. Else `right = mid - 1`.
- **Golden Rule:** Avoid integer overflow: use `mid <= x / mid` instead of `mid * mid <= x`.
- **🔑 Mental Trick:** **Guessing Game on Answer Space** — Binary search on the integer range `1..x` to find the largest integer whose square is $\le x$.
- **Complexity:** Time: $O(\log x)$ | Space: $O(1)$

---

### 4. Search in Rotated Sorted Array (LeetCode 33)
- **Note Link:** [SearchTargetInRotatedArray.md](file:///d:/dsa-patterns-java/notes/binary-search/clasic-binary-search/SearchTargetInRotatedArray.md)
- **Core Logic:** At least one half (`[left..mid]` or `[mid..right]`) is ALWAYS properly sorted.
  - If `nums[left] <= nums[mid]`: Left half is sorted. Check if target lies in `[nums[left], nums[mid]]`.
  - Else: Right half is sorted. Check if target lies in `[nums[mid], nums[right]]`.
- **Golden Rule:** Identify which half is sorted first, then check if target falls inside that sorted range.
- **🔑 Mental Trick:** **Rotated Bookshelf** — One side of the broken shelf is still in perfect alphabetical order. Check if your book is on that neat side; if not, it MUST be on the other side.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 5. Find Minimum in Rotated Sorted Array (LeetCode 154)
- **Note Link:** [MinElementInRoteatedArray.md](file:///d:/dsa-patterns-java/notes/binary-search/clasic-binary-search/MinElementInRoteatedArray.md)
- **Core Logic:** Compare `nums[mid]` with `nums[right]`.
  - If `nums[mid] > nums[right]`: Minimum lies in right half (`left = mid + 1`).
  - Else: Minimum lies in left half including `mid` (`right = mid`).
- **Golden Rule:** `nums[mid] > nums[right]` means the rotation pivot point lies strictly to the right.
- **🔑 Mental Trick:** **Cliff Drop** — The minimum element is the drop point where sorting breaks.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 6. Find Peak Element (LeetCode 162)
- **Note Link:** [FindPeakElement.md](file:///d:/dsa-patterns-java/notes/binary-search/clasic-binary-search/FindPeakElement.md)
- **Core Logic:** Compare `nums[mid]` with `nums[mid + 1]`.
  - If `nums[mid] < nums[mid + 1]`: Peak must be to the right (`left = mid + 1`).
  - Else: Peak is at `mid` or to the left (`right = mid`).
- **Golden Rule:** Follow the ascending slope! A peak is guaranteed to exist in the direction of the slope.
- **🔑 Mental Trick:** **Climbing the Mountain** — If the ground goes uphill to your right, keep walking right to find the mountain summit.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 7. Ceiling in a Sorted Array
- **Note Link:** [CeilingInSortedArray.md](file:///d:/dsa-patterns-java/notes/binary-search/lowerbound-upperbound/CeilingInSortedArray.md)
- **Core Logic:** Find smallest element $\ge x$. If `nums[mid] >= x`, store `ans = mid` and search left (`right = mid - 1`). Else `left = mid + 1`.
- **Golden Rule:** Lower Bound concept.
- **🔑 Mental Trick:** **Smallest Upper Ticket** — Find ticket $\ge x$, then check if a cheaper valid ticket exists on the left.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 8. Floor in a Sorted Array
- **Note Link:** [FloorInSortedArray.md](file:///d:/dsa-patterns-java/notes/binary-search/lowerbound-upperbound/FloorInSortedArray.md)
- **Core Logic:** Find largest element $\le x$. If `nums[mid] <= x`, store `ans = mid` and search right (`left = mid + 1`). Else `right = mid - 1`.
- **Golden Rule:** Largest element under cap $x$.
- **🔑 Mental Trick:** **Highest Budget Item** — Find item $\le x$, then look right to see if you can buy something even closer to budget $x$.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 9. Find First and Last Position of Element (LeetCode 34)
- **Note Link:** [FindFirstAndLastPosition.md](file:///d:/dsa-patterns-java/notes/binary-search/lowerbound-upperbound/FindFirstAndLastPosition.md)
- **Core Logic:** Run two binary searches.
  - First position: When `nums[mid] == target`, record `first = mid` and squeeze left (`right = mid - 1`).
  - Last position: When `nums[mid] == target`, record `last = mid` and squeeze right (`left = mid + 1`).
- **Golden Rule:** Don't stop at first match; push `right` leftward for first occurrence, push `left` rightward for last occurrence.
- **🔑 Mental Trick:** **Bookend Search** — Peek left for where duplicates start, peek right for where duplicates end.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

---

### 10. Find Kth Rotation
- **Note Link:** [FindKthRotation.md](file:///d:/dsa-patterns-java/notes/binary-search/lowerbound-upperbound/FindKthRotation.md)
- **Core Logic:** Number of rotations equals index of the minimum element in the rotated sorted array.
- **Golden Rule:** `rotations = index_of_minimum_element`.
- **🔑 Mental Trick:** **Minimum Index Shift** — The position of the absolute smallest element tells you exactly how many steps the array was shifted.
- **Complexity:** Time: $O(\log n)$ | Space: $O(1)$

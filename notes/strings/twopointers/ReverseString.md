# Reverse String (In-Place, O(1) Memory)

## Problem
Given an array of characters `s`, reverse the array **in-place** using **O(1) extra memory**.

---

## Algorithm (Two-Pointer Approach)

1. **Initialize pointers**:
    - `left = 0`
    - `right = s.length - 1`

2. **Loop until left < right**:
    - Swap `s[left]` and `s[right]`.
    - Move `left++` forward.
    - Move `right--` backward.

3. **Stop when pointers meet**:
    - The array is fully reversed.

---

## Complexity
- **Time:** O(n) → each element swapped once.
- **Space:** O(1) → only a temporary variable used.

---

## Dry Run Example
Input: `['h','e','l','l','o']`

- Swap `h` ↔ `o` → `['o','e','l','l','h']`
- Swap `e` ↔ `l` → `['o','l','l','e','h']`
- Stop when pointers meet.

Output: `"olleh"`

---

## 🔑 Remember Trick
Think of **two friends walking towards each other**:
- One starts at the **left end**.
- One starts at the **right end**.
- They **swap seats** each time they meet.
- Keep walking until they meet in the middle → the string is reversed.

---

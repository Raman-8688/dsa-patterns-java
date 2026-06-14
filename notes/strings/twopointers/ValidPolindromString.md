# Palindrome Check (Ignore Non-Alphanumeric, Case-Insensitive)

## Problem
Given a string `s`, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

---

## Algorithm (Two-Pointer Approach)

1. **Initialize pointers**:
    - `left = 0`
    - `right = s.length - 1`

2. **Loop until left < right**:
    - Skip non-alphanumeric characters:
        - If `s[left]` is not a letter/digit → move `left++`.
        - If `s[right]` is not a letter/digit → move `right--`.
    - Compare characters case-insensitively:
        - If mismatch → return false.
    - Otherwise → move inward (`left++`, `right--`).

3. **Stop when pointers meet**:
    - If no mismatches found → return true.

---

## Complexity
- **Time:** O(n) → each character checked once.
- **Space:** O(1) → only pointers used.

---

## Dry Run Example
Input: `"A man, a plan, a canal: Panama"`

- Compare `A` vs `a` → match.
- Skip spaces and punctuation.
- Compare `m` vs `m`, `a` vs `a`, … all match.
- End of loop → return true.

Output: **Palindrome**

---

## 🔑 Remember Trick
Think of **two mirrors facing each other**:
- One pointer starts at the **left end**.
- One pointer starts at the **right end**.
- They move inward, checking reflections.
- If all reflections match → it’s a palindrome.

---

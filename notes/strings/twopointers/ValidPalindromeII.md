# Valid Palindrome II (Delete at Most One Character)

## Problem
Given a string `s`, return true if it can be a palindrome after deleting **at most one character**.

---

## Brute Force Approach

1. Check if `s` is already a palindrome.
2. If not, try removing each character one by one:
    - Form a new string without that character.
    - Check if the new string is a palindrome.
3. If any removal works → return true, else false.

**Complexity:**
- Time: O(n^2) (removing each char and checking palindrome).
- Space: O(n) (new string creation).

---

## Optimal Two-Pointer Approach

1. Use two pointers (`left`, `right`) from both ends.
2. Compare characters:
    - If equal → move inward.
    - If mismatch → try skipping either `left` or `right` character.
3. If either skip leads to palindrome → return true.
4. Otherwise → return false.

**Complexity:**
- Time: O(n) (single pass).
- Space: O(1).

---

## Dry Run Example
Input: `"abca"`

- Compare `a` vs `a` → match.
- Compare `b` vs `c` → mismatch.
- Try skipping `b`: check `"aca"` → palindrome.
- Try skipping `c`: check `"aba"` → palindrome.
- Result: **true**.

---

## 🔑 Remember Trick
Think of **two guards walking inward**:
- If they see a mismatch, allow **one guard to step aside** (skip one character).
- If after that everything matches → it’s valid palindrome.

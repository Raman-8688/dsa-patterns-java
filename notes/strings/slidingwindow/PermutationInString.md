# Permutation in String

## Problem
Given two strings `s1` and `s2`, return true if `s2` contains a permutation of `s1`.  
In other words, check if any substring of `s2` is an anagram of `s1`.

Example:  
Input: `s1 = "ab", s2 = "eidbaooo"`  
Output: `true`  
Explanation: `"ba"` in `s2` is a permutation of `"ab"`.

---

## Brute Force Approach

### Algorithm
1. Compute the frequency count of characters in `s1`.
2. For each substring of length `n = s1.length()` in `s2`:
    - Compute frequency count of that substring.
    - Compare with `s1`’s frequency count.
    - If equal → return true.
3. If no substring matches → return false.

### Complexity
- **Time:** O(m * n) (for each substring of length n in s2, recompute frequency).
- **Space:** O(26) → constant for character counts.

### Intuition
We brute-force by checking every possible substring of length `n` in `s2`. Works but inefficient for large strings.

---

## Optimal Sliding Window Approach

### Algorithm
1. Compute frequency count of `s1` (`freq` array or map).
2. Use a sliding window of size `n = s1.length()` over `s2`:
    - Expand `right` pointer, decrement frequency for that character.
    - If frequency was positive before decrement → reduce `count` (remaining chars to match).
    - If `count == 0` → return true (valid permutation found).
    - If window size exceeds `n`:
        - Move `left` pointer forward.
        - Restore frequency for the character leaving the window.
        - If restored frequency ≥ 0 → increment `count`.
3. Continue until the end of `s2`.

### Complexity
- **Time:** O(m) (each character processed once).
- **Space:** O(26) → constant.

---

## Dry Run Example
Input: `s1 = "ab", s2 = "eidbaooo"`

- `freq` for `"ab"` = {a:1, b:1}.
- Window expands: `"ei"` → not valid.
- Window `"id"` → not valid.
- Window `"db"` → contains `b`.
- Window `"ba"` → matches permutation of `"ab"`.
- Return true.

Output: **true**

---

## Why Sliding Window Works
- The window always has size equal to `s1`.
- The frequency array tracks how many characters are still needed.
- When all needed characters are matched (`count == 0`), we found a valid permutation.
- Efficient because we update counts incrementally instead of recomputing for each substring.

---

## 🔑 Remember Trick
Think of **a checklist of characters**:
- Each character in `s1` is on the checklist.
- Slide a window over `s2`, ticking off characters as they appear.
- If the checklist is fully ticked (count == 0) → permutation found.
- If a character leaves the window, untick it from the checklist.
- Keep sliding until the end.

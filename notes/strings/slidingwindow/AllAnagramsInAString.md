# Find All Anagrams in a String

## Problem
Given two strings `s` and `p`, return all start indices of `p`'s anagrams in `s`.  
An anagram is a rearrangement of letters.

Example:  
Input: `s = "cbaebabacd", p = "abc"`  
Output: `[0, 6]`  
Explanation: Substrings `"cba"` and `"bac"` are anagrams of `"abc"`.

---

## Brute Force Approach

### Algorithm
1. Compute the frequency count of characters in `p`.
2. For each substring of length `k = p.length()` in `s`:
    - Compute frequency count of that substring.
    - Compare with `p`’s frequency count.
    - If equal → record starting index.
3. Return all indices.

### Complexity
- **Time:** O((n-k+1) * k) ≈ O(n*k)
    - For each window, recompute frequency.
- **Space:** O(26) → constant for character counts.

---

## Optimal Sliding Window Approach

### Algorithm
1. Compute frequency count of `p` (`pCount`).
2. Use a sliding window of size `k` over `s`:
    - Maintain frequency count of current window (`sCount`).
    - Compare `sCount` with `pCount`.
    - If equal → record starting index.
3. Slide window:
    - Add new character at right.
    - Remove old character at left.
    - Update counts efficiently.
4. Continue until end of string.

### Complexity
- **Time:** O(n)
    - Each character processed once.
- **Space:** O(26) → constant.

---

## Dry Run Example
Input: `s = "abab", p = "ab"`

- Window size = 2.
- Window `"ab"` → matches → index 0.
- Window `"ba"` → matches → index 1.
- Window `"ab"` → matches → index 2.
- Result = `[0, 1, 2]`.

---

## 🔑 Remember Trick
Think of **a sliding window as a moving magnifying glass**:
- Place the glass over `s` with size equal to `p`.
- Compare letter counts inside the glass with `p`.
- Slide one step at a time, updating counts.
- Every match → record index.

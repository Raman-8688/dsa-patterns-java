# Longest Palindromic Substring

## Problem
Given a string `s`, return the longest palindromic substring.

---

## Brute Force Approach

1. Generate all substrings.
2. For each substring, check if it is a palindrome.
3. Track the longest palindrome found.

**Complexity:**
- Time: O(n^3) (substring generation + palindrome check).
- Space: O(1).

---

## Optimal Expand Around Center Approach

1. Every palindrome has a center:
    - Single character (odd length).
    - Between two characters (even length).
2. Expand outward from each center while characters match.
3. Track the longest palindrome found.

**Complexity:**
- Time: O(n^2).
- Space: O(1).

---

## Dry Run Example
Input: `"babad"`

- Center at `a`: expand → `"aba"`.
- Center at `b`: expand → `"bab"`.
- Longest palindrome = `"bab"` (or `"aba"`).

Output: `"bab"` or `"aba"`

---

## 🔑 Remember Trick
Think of **a mirror expanding from the middle**:
- Place the mirror at each character (odd case).
- Place the mirror between two characters (even case).
- Expand outward until the reflection breaks.
- The widest mirror span is your longest palindrome.

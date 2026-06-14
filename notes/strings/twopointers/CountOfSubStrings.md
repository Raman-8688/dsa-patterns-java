# Count of Palindromic Substrings

## Problem
Given a string `s`, return the number of palindromic substrings in it.  
A substring is palindromic if it reads the same forward and backward.

---

## Brute Force Approach

### Algorithm
1. Generate all possible substrings using two nested loops:
    - Outer loop → start index `i`.
    - Inner loop → end index `j`.
2. For each substring `s[i..j]`, check if it is a palindrome:
    - Compare characters from both ends inward.
    - If mismatch → not a palindrome.
    - If all match → palindrome.
3. Count every palindrome found.

### Complexity
- **Time:** O(n^3)
    - O(n^2) substrings × O(n) palindrome check.
- **Space:** O(1).

---

## Optimal Expand Around Center Approach

### Algorithm
1. Every palindrome has a **center**:
    - Single character (odd length).
    - Between two characters (even length).
2. For each index `i`:
    - Expand around `(i, i)` → odd length palindromes.
    - Expand around `(i, i+1)` → even length palindromes.
3. While expanding:
    - If characters match → increment count.
    - Move outward (`left--`, `right++`).
    - Stop when mismatch or bounds exceeded.
4. Sum all counts.

### Complexity
- **Time:** O(n^2)
    - Each expansion checks at most O(n) characters.
- **Space:** O(1).

---

## Dry Run Example
Input: `"aaa"`

- Centers:
    - At index 0: `"a"`, `"aa"`.
    - At index 1: `"a"`, `"aa"`, `"aaa"`.
    - At index 2: `"a"`.
- Total palindromic substrings = 6.

Output: **6**

---

## 🔑 Remember Trick
Think of **dropping mirrors at each position**:
- Place a mirror at each character (odd case).
- Place a mirror between characters (even case).
- Expand outward while reflections match.
- Count every reflection → total palindromic substrings.

# Minimum Window Substring (LeetCode 76)

---

## Problem
Given two strings `s` and `t` of lengths `m` and `n` respectively, return the **minimum window substring** of `s` such that every character in `t` (including duplicates) is included in the window.  
If there is no such substring, return the empty string `""`.

**Example 1:**  
Input: `s = "ADOBECODEBANC"`, `t = "ABC"`  
Output: `"BANC"`  
Explanation: The minimum window substring `"BANC"` includes `'A'`, `'B'`, and `'C'` from string `t`.

**Example 2:**  
Input: `s = "a"`, `t = "aa"`  
Output: `""`  
Explanation: Both `'a'`s from `t` must be included in the window, but `s` has only one `'a'`.

---

## Approach 1: Brute Force

### Algorithm
1. Generate all possible substrings of `s` using nested loops `i` and `j`.
2. For each substring, count character frequencies and check if it contains all characters of `t` with required frequencies.
3. Keep track of the shortest valid substring found.

### Complexity
- **Time:** $O(n^2 \cdot m)$
- **Space:** $O(m)$

---

## Approach 2: Optimal Sliding Window (Expand Right, Shrink Left)

### Algorithm
1. Create a frequency array/map `map` for target string `t`, and set `count = t.length()`.
2. Expand `right` pointer:
    - If `s[right]` exists in `map` and `map[s[right]] > 0`, decrement `count`.
    - Decrement `map[s[right]]`.
    - Move `right++`.
3. When `count == 0` (window is valid):
    - Update `minLen` and `minStart`.
    - Shrink window from `left`:
      - Increment `map[s[left]]`.
      - If `map[s[left]] > 0`, increment `count` (window becomes invalid).
      - Move `left++`.
4. Return `s.substring(minStart, minStart + minLen)`.

### Complexity
- **Time:** $O(n)$
- **Space:** $O(1)$ (bounded by character set size, 128 ASCII).

---

## Code
```java
package com.raman.dsa.strings.slidingwindow;

public class MinimumWindowSubstring {

    public static String minWindowOptimal(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length();

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (map[rChar] > 0) count--;
            map[rChar]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char lChar = s.charAt(left);
                map[lChar]++;
                if (map[lChar] > 0) count++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindowOptimal("ADOBECODEBANC", "ABC")); // "BANC"
    }
}
```

---

## Why This Works
- Expand `right` until all required characters are satisfied (`count == 0`).
- Once valid, shrink `left` to squeeze out unnecessary characters while maintaining validity. This guarantees finding the absolute smallest window starting at each valid point.

---

## 🔑 Remember Trick
Think of **Packing a Suitcase with Required Items (`t`)**:
- Expand your bag to the right until you've packed **every single required item**.
- Once fully packed, throw away unnecessary extra items from the top (`left` pointer) to make the bag as **compact as possible** before closing it!

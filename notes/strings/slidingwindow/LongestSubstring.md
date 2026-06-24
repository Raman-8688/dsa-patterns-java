# Longest Substring with Exactly K Distinct Characters

## Problem
Given a string `s` and an integer `k`, find the length of the longest substring that contains **exactly k distinct characters**.

Example:  
Input: `s = "aabacbebebe", k = 3`  
Output: `7`  
Explanation: The longest substring with exactly 3 distinct characters is `"cbebebe"`.

---

## Brute Force Approach

### Algorithm
1. Iterate over all possible substrings:
    - Outer loop → start index `i`.
    - Inner loop → end index `j`.
2. For each substring `s[i..j]`:
    - Use a **set** to track distinct characters.
    - If the set size equals `k` → update maximum length.
    - If the set size exceeds `k` → break inner loop (no need to expand further).
3. Return the maximum length found.

### Complexity
- **Time:** O(n^2) (nested loops, set operations).
- **Space:** O(k) (set stores distinct characters).

### Intuition
We brute-force by checking every substring and counting distinct characters. Works fine for small strings but inefficient for large inputs.

---

## Optimal Sliding Window Approach (HashMap)

### Algorithm
1. Use two pointers: `left` and `right` to define a sliding window.
2. Use a **HashMap** to store character frequencies in the current window.
3. Expand `right`:
    - Add character to map and update frequency.
    - If map size > k:
        - Shrink window from `left` until map size ≤ k.
    - If map size == k:
        - Update maximum length = `max(max, right - left + 1)`.
4. Continue until the end of the string.

### Complexity
- **Time:** O(n) (each character processed once).
- **Space:** O(k) (map stores at most k distinct characters).

---

## Dry Run Example
Input: `s = "aabacbebebe", k = 3`

- Start with empty window.
- Expand until window = `"aabacb"` → distinct chars = {a, b, c}. Length = 6.
- Expand further → `"cbebebe"` → distinct chars = {c, b, e}. Length = 7.
- This is the longest substring with exactly 3 distinct characters.

Output: **7**

---

## Why Sliding Window Works
- The window represents the current substring.
- The HashMap tracks distinct characters and their counts.
- If distinct characters exceed `k`, shrink from the left until valid.
- This ensures we always maintain a valid window and update the maximum length efficiently.

---

## 🔑 Remember Trick
Think of a **window with k slots**:
- Each slot holds a distinct character.
- Expand the window until all slots are filled.
- If a new character tries to enter (slot overflow), push the left side forward until only k slots remain.
- The widest valid window span is your answer.

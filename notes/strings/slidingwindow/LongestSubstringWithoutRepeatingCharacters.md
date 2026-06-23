# Longest Substring Without Repeating Characters

## Problem
Given a string `s`, find the length of the longest substring without repeating characters.

Example:  
Input: `"abcabcbb"`  
Output: `3`  
Explanation: The longest substring without repeating characters is `"abc"`.

---

## Brute Force Approach

### Algorithm
1. Iterate over all possible substrings:
    - Outer loop → start index `i`.
    - Inner loop → end index `j`.
2. For each substring `s[i..j]`:
    - Use a **set** to track characters.
    - If a character repeats → break out of the inner loop.
    - Otherwise → update maximum length.
3. Return the maximum length found.

### Complexity
- **Time:** O(n^3)
    - O(n^2) substrings × O(n) check for uniqueness.
- **Space:** O(n) for the set.

### Intuition
You are brute-forcing by checking every possible substring and verifying if it has duplicates. This works but is slow for large strings.

---

## Optimal Sliding Window Approach (HashMap)

### Algorithm
1. Use two pointers: `left` and `right` to define a sliding window.
2. Use a **HashMap** to store the last index of each character.
3. For each character at `right`:
    - If it already exists in the map:
        - Move `left` to `max(left, map[ch] + 1)` to skip past the duplicate.
    - Update the character’s latest index in the map.
    - Update maximum length = `max(max, right - left + 1)`.
4. Continue until the end of the string.

### Complexity
- **Time:** O(n) (each character processed once).
- **Space:** O(n) (map stores characters).

---

## Dry Run Example
Input: `"abcabcbb"`

- Start: `left=0`, `right=0` → window `"a"` → length 1.
- Expand: `"ab"` → length 2.
- Expand: `"abc"` → length 3.
- At `right=3` (`a` repeats): move `left` to 1.
- Window becomes `"bca"` → length 3.
- Continue sliding → longest length remains 3.

Output: **3**

---

## Why Sliding Window Works
- The window represents the current substring without duplicates.
- When a duplicate is found, instead of starting over, you **shift the left pointer** just enough to remove the duplicate.
- This ensures each character is processed only once, making it efficient.

---

## 🔑 Remember Trick
Think of a **moving fence**:
- The fence expands to include new characters.
- If a duplicate enters, shift the **left side of the fence** past the duplicate.
- The widest fence span without duplicates is your longest substring.

Another way to remember:  
**“Map remembers last seen index → left jumps past duplicate → window stays clean.”**

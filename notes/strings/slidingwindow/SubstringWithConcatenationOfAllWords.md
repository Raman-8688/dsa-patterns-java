# Substring with Concatenation of All Words (LeetCode 30)

---

## Problem
You are given a string `s` and an array of strings `words`. All strings in `words` are of the **same length**.  
A **concatenated substring** in `s` is a substring that contains all the strings of any permutation of `words` concatenated together.  
Return the starting indices of all concatenated substrings in `s`.

**Example:**  
Input: `s = "barfoothefoobarman"`, `words = ["foo", "bar"]`  
Output: `[0, 9]`  
Explanation: Substrings starting at index 0 (`"barfoo"`) and index 9 (`"foobar"`) are concatenations of `["foo", "bar"]`.

---

## Approach 1: Fixed Window with HashMap Match

### Algorithm
1. Calculate `wordLen = words[0].length()`, `numWords = words.length`, and total `totalLen = wordLen * numWords`.
2. Build a frequency map `wordMap` of all words in `words`.
3. Loop `i` from `0` to `s.length() - totalLen`:
    - Create a map `seen`.
    - Iterate `j` from `0` to `numWords - 1`:
      - Extract substring `word = s.substring(i + j * wordLen, i + (j + 1) * wordLen)`.
      - If `word` is not in `wordMap` or `seen` count exceeds `wordMap` count → break.
      - Increment `seen[word]`.
    - If `j == numWords`, add `i` to result list.

### Complexity
- **Time:** $O(N \cdot M \cdot L)$ where $N = \text{length of } s$, $M = \text{number of words}$, $L = \text{word length}$.
- **Space:** $O(M \cdot L)$

---

## Code
```java
package com.raman.dsa.strings.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenatedSubstring {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return ans;

        Map<String, Integer> targetMap = new HashMap<>();
        for (String w : words) {
            targetMap.put(w, targetMap.getOrDefault(w, 0) + 1);
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;

        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < numWords) {
                int start = i + j * wordLen;
                String word = s.substring(start, start + wordLen);

                if (!targetMap.containsKey(word)) break;

                seen.put(word, seen.getOrDefault(word, 0) + 1);

                if (seen.get(word) > targetMap.get(word)) break;

                j++;
            }
            if (j == numWords) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words)); // [0, 9]
    }
}
```

---

## Why This Works
- Because all words have equal length `wordLen`, a candidate window always has fixed length `wordLen * numWords`.
- Breaking the window into `wordLen`-chunked blocks allows matching word counts against target frequencies easily via HashMaps.

---

## 🔑 Remember Trick
Think of **Lego Blocks of Fixed Width**:
- Each word is a Lego block of width `L`.
- Slide a window of size `M * L` over the string.
- Slice the window into `M` equal Lego blocks. If all pieces match your target set of Lego blocks, record the starting position!

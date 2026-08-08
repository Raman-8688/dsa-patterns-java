# 🔤 Strings Module (Two Pointers & Sliding Window) - Quick Revision Guide

---

## 🚀 Module Core Motive & Blueprint
String manipulation questions usually combine **Two Pointers** (for palindromes, reversals, symmetry checks) and **Sliding Window + Frequency Maps/Arrays** (for substring patterns, anagrams, permutations).

**Core Advantage:** Avoids expensive string copying or $O(n^2)$ substring generation by maintaining frequency arrays (e.g. `int[128]` for ASCII or `int[26]` for lowercase letters) and pointer boundaries.

---

## 🔍 How to Instantly Identify String Pattern Triggers

### Two Pointers Triggers:
- **"Palindrome"** / **"Valid Palindrome"** / **"Reverse string"**.
- Checking symmetry from edges or expanding from center.

### Sliding Window Triggers:
- **"Longest substring without repeating characters"**.
- **"All anagrams in a string"** / **"Permutation of string"**.
- **"Minimum window containing all characters"**.
- **"Substring concatenated from all words"**.

---

## ⚡ Golden Formulas & Universal Templates

### Character Frequency Array (Fast Hash Table for ASCII/Lowercase)
```java
int[] freq = new int[128]; // or int[26] for 'a'-'z'
freq[ch]++;                // Add char
freq[ch]--;                // Remove char
```

### Palindrome Center Expansion Template
```java
private int expand(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1; // Length of palindrome centered at (left, right)
}
```

---

## 🧠 Question-by-Question Flash Recap

### ── PART 1: TWO POINTERS (STRINGS) ──

#### 1. Reverse String
- **Note Link:** [ReverseString.md](file:///d:/dsa-patterns-java/notes/strings/twopointers/ReverseString.md)
- **Core Logic:** `left = 0`, `right = n - 1`. Swap `s[left]` and `s[right]`, then `left++`, `right--`.
- **Golden Rule:** In-place string reversal using 2 pointers.
- **🔑 Mental Trick:** **Mirror Flip** — Swap outward elements inward until pointers cross.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

#### 2. Valid Palindrome I
- **Note Link:** [ValidPolindromString.md](file:///d:/dsa-patterns-java/notes/strings/twopointers/ValidPolindromString.md)
- **Core Logic:** `left = 0`, `right = n - 1`. Skip non-alphanumeric characters. Compare lowercased characters at `left` and `right`.
- **Golden Rule:** `Character.isLetterOrDigit(c)` + `Character.toLowerCase(c)`.
- **🔑 Mental Trick:** **Bouncer Filter** — Skip spaces & symbols; only match letters against their mirror twin.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

#### 3. Valid Palindrome II (At Most 1 Deletion)
- **Note Link:** [ValidPalindromeII.md](file:///d:/dsa-patterns-java/notes/strings/twopointers/ValidPalindromeII.md)
- **Core Logic:** `left = 0`, `right = n - 1`. When `s[left] != s[right]`, check if deleting `left` (`isPalindrome(s, left + 1, right)`) OR deleting `right` (`isPalindrome(s, left, right - 1)`) makes it valid.
- **Golden Rule:** One mismatch allowed $\implies$ branch into two sub-checks skipping either `left` or `right`.
- **🔑 Mental Trick:** **Second Chance Free Pass** — On first conflict, test skipping the left character OR right character. If either works, you win!
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

#### 4. Longest Palindromic Substring
- **Note Link:** [LongestPalindrome.md](file:///d:/dsa-patterns-java/notes/strings/twopointers/LongestPalindrome.md)
- **Core Logic:** Loop `i` from `0` to `n - 1`. Expand around odd center `(i, i)` and even center `(i, i + 1)`. Track max length and starting index.
- **Golden Rule:** Total $2n - 1$ centers. Odd centers `(i, i)`, Even centers `(i, i + 1)`.
- **🔑 Mental Trick:** **Ripple Expansion** — Throw a stone at index `i` and expand outward like ripples on water while left and right characters match.
- **Complexity:** Time: $O(n^2)$ | Space: $O(1)$

---

#### 5. Count of Substrings
- **Note Link:** [CountOfSubStrings.md](file:///d:/dsa-patterns-java/notes/strings/twopointers/CountOfSubStrings.md)
- **Core Logic:** Count total valid substring windows satisfying conditions.
- **Golden Rule:** Use window endpoints to calculate valid substring combinations.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

### ── PART 2: SLIDING WINDOW (STRINGS) ──

#### 6. Longest Substring Without Repeating Characters (LeetCode 3)
- **Note Link:** [LongestSubstringWithoutRepeatingCharacters.md](file:///d:/dsa-patterns-java/notes/strings/slidingwindow/LongestSubstringWithoutRepeatingCharacters.md)
- **Core Logic:** Track character last seen index in `int[128] lastPos` initialized to `-1`. Expand `right`. If `lastPos[ch] >= left`, shrink `left = lastPos[ch] + 1`. Update `lastPos[ch] = right` and `maxLen = max(maxLen, right - left + 1)`.
- **Golden Rule:** Jump `left` directly to `lastPos[ch] + 1` to eliminate duplicate instantly.
- **🔑 Mental Trick:** **Teleport Left** — Don't shrink `left` step by step. When a duplicate character appears, teleport `left` past the previous duplicate!
- **Complexity:** Time: $O(n)$ | Space: $O(1)$ (128 array)

---

#### 7. Permutation in String (LeetCode 567)
- **Note Link:** [PermutationInString.md](file:///d:/dsa-patterns-java/notes/strings/slidingwindow/PermutationInString.md)
- **Core Logic:** Fixed sliding window of size `len(s1)`. Build frequency arrays `s1Map` and `s2Map`. Compare maps using `Arrays.equals(s1Map, s2Map)`.
- **Golden Rule:** Window size is fixed to `s1.length()`.
- **🔑 Mental Trick:** **Exact Anagram Stamp** — Slide a fixed stencil of length `len(s1)` over `s2` and check if letter counts match `s1` exactly.
- **Complexity:** Time: $O(n_2)$ | Space: $O(1)$ (26 array)

---

#### 8. Find All Anagrams in a String (LeetCode 438)
- **Note Link:** [AllAnagramsInAString.md](file:///d:/dsa-patterns-java/notes/strings/slidingwindow/AllAnagramsInAString.md)
- **Core Logic:** Fixed sliding window of size `len(p)`. Maintain frequency match. When window frequencies equal `p`'s frequencies, add `right - len(p) + 1` to output list.
- **Golden Rule:** Fixed window size `p.length()`.
- **🔑 Mental Trick:** **Moving Anagram Scanner** — Slide a scanner of size `p.length()` and record every starting index where frequencies match `p`.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

#### 9. Longest Substring with K Distinct Characters
- **Note Link:** [LongestSubstring.md](file:///d:/dsa-patterns-java/notes/strings/slidingwindow/LongestSubstring.md)
- **Core Logic:** Expand `right` adding `s[right]` to HashMap. While `map.size() > k`, shrink `left` (`map[s[left]]--`, remove if 0, `left++`). If `map.size() == k`, update `maxLen`.
- **Golden Rule:** `map.size()` tracks unique character count in current window.
- **🔑 Mental Trick:** **Hotel Room Capacity** — Your window has room for at most $K$ distinct character guests. When a $(K+1)$th guest arrives, kick out guests from `left` until distinct count is back to $K$.
- **Complexity:** Time: $O(n)$ | Space: $O(k)$

---

#### 10. Minimum Window Substring (LeetCode 76)
- **Note Link:** [MinimumWindowSubstring.md](file:///d:/dsa-patterns-java/notes/strings/slidingwindow/MinimumWindowSubstring.md)
- **Core Logic:** Frequency `map[128]` of `t`. Expand `right`: if `map[s[right]] > 0` `count--`; `map[s[right]]--`. While `count == 0` (window valid), update `minLen` & `minStart`, then shrink `left` (`map[s[left]]++`; if `map[s[left]] > 0` `count++`; `left++`).
- **Golden Rule:** Expand `right` until valid (`count == 0`), then squeeze `left` to find absolute minimum window length.
- **🔑 Mental Trick:** **Pack & Squeeze** — Expand to capture all required items (`t`), then squeeze `left` as much as possible to shrink baggage size.
- **Complexity:** Time: $O(n)$ | Space: $O(1)$

---

#### 11. Substring with Concatenation of All Words (LeetCode 30)
- **Note Link:** [SubstringWithConcatenationOfAllWords.md](file:///d:/dsa-patterns-java/notes/strings/slidingwindow/SubstringWithConcatenationOfAllWords.md)
- **Core Logic:** All words have equal length `wordLen`. Window length = `numWords * wordLen`. Loop `i` from `0` to `s.length() - totalLen`. Check chunked word frequency against `wordMap`.
- **Golden Rule:** Fixed chunking by `wordLen`.
- **🔑 Mental Trick:** **Fixed-Width Word Blocks** — Slice fixed-size `wordLen` blocks inside the window and match them against target word counts.
- **Complexity:** Time: $O(N \cdot M \cdot L)$ | Space: $O(M \cdot L)$

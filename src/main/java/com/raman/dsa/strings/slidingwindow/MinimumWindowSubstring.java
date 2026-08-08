package com.raman.dsa.strings.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     * Brute Force Approach: Check all substrings of s
     * Time Complexity: O(n^2 * m)
     * Space Complexity: O(m)
     */
    public static String minWindowBruteForce(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int minLen = Integer.MAX_VALUE;
        String minSub = "";

        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> sMap = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

                if (containsAll(sMap, tMap)) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        minSub = s.substring(i, j + 1);
                    }
                    break; // Smaller substring from index i found
                }
            }
        }
        return minSub;
    }

    private static boolean containsAll(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (char c : tMap.keySet()) {
            if (sMap.getOrDefault(c, 0) < tMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Optimal Approach: Sliding Window with Frequency Map & Count
     * Time Complexity: O(n)
     * Space Complexity: O(1) [since charset is bounded by ASCII 128]
     */
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
            if (map[rChar] > 0) {
                count--;
            }
            map[rChar]--;
            right++;

            // When window contains all characters of t
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char lChar = s.charAt(left);
                map[lChar]++;
                if (map[lChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println("--- Minimum Window Substring ---");
        System.out.println("Brute Force: " + minWindowBruteForce(s, t)); // Output: BANC
        System.out.println("Optimal BS : " + minWindowOptimal(s, t));    // Output: BANC

        String s2 = "a", t2 = "aa";
        System.out.println("Optimal (No match): \"" + minWindowOptimal(s2, t2) + "\""); // Output: ""
    }
}

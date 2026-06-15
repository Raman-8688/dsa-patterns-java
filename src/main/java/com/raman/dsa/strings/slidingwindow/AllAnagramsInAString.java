package com.raman.dsa.strings.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsInAString {


        // Brute Force Approach
        public static List<Integer> findAnagramsBrute(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int n = s.length();
            int k = p.length();

            int[] pCount = new int[26];
            for (char c : p.toCharArray()) {
                pCount[c - 'a']++;
            }

            for (int i = 0; i <= n - k; i++) {
                int[] sCount = new int[26];
                for (int j = i; j < i + k; j++) {
                    sCount[s.charAt(j) - 'a']++;
                }
                if (Arrays.equals(pCount, sCount)) {
                    res.add(i);
                }
            }
            return res;
        }

        // Optimal Sliding Window Approach
        public static List<Integer> findAnagramsOptimal(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int n = s.length();
            int k = p.length();

            if (n < k) return res;

            int[] pCount = new int[26];
            int[] sCount = new int[26];

            for (char c : p.toCharArray()) {
                pCount[c - 'a']++;
            }

            // Initial window
            for (int i = 0; i < k; i++) {
                sCount[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(pCount, sCount)) {
                res.add(0);
            }

            // Slide the window
            for (int i = k; i < n; i++) {
                sCount[s.charAt(i) - 'a']++; // add new char
                sCount[s.charAt(i - k) - 'a']--; // remove old char

                if (Arrays.equals(pCount, sCount)) {
                    res.add(i - k + 1);
                }
            }

            return res;
        }

        public static void main(String[] args) {
            String s1 = "cbaebabacd";
            String p1 = "abc";
            System.out.println("Input: s = " + s1 + ", p = " + p1);
            System.out.println("Brute Force Output: " + findAnagramsBrute(s1, p1));
            System.out.println("Optimal Output: " + findAnagramsOptimal(s1, p1));
            // Expected: [0, 6]

            String s2 = "abab";
            String p2 = "ab";
            System.out.println("\nInput: s = " + s2 + ", p = " + p2);
            System.out.println("Brute Force Output: " + findAnagramsBrute(s2, p2));
            System.out.println("Optimal Output: " + findAnagramsOptimal(s2, p2));
            // Expected: [0, 1, 2]
        }


}

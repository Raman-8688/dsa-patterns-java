package com.raman.dsa.strings.twopointers;

public class ValidPalindromeWithOneSkip {
    public static void main(String[] args) {
        String s1 = "abca";
        System.out.println("Is valid palindrome? " + validPalindrome(s1)); // true (remove 'b' or 'c')

        String s2 = "racecar";
        System.out.println("Is valid palindrome? " + validPalindrome(s2)); // true

        String s3 = "abcdef";
        System.out.println("Is valid palindrome? " + validPalindrome(s3)); // false
    }

    private static boolean validPalindrome(String s1) {
        int left=0;
        int right=s1.length()-1;
        while(left<right){
            if(s1.charAt(left)!=s1.charAt(right))
                return isPolindrome(s1,left+1,right) || isPolindrome(s1,left,right-1);
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPolindrome(String s1, int left, int right) {
        while (left<right){
            if(s1.charAt(left)!=s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

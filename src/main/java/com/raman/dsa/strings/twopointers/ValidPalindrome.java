package com.raman.dsa.strings.twopointers;

public class ValidPalindrome {


    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println("Is Palindrome? " + isPalindrome(s1)); // true

        String s2 = "race a car";
        System.out.println("Is Palindrome? " + isPalindrome(s2)); // false

        String s3 = "No lemon, no melon";
        System.out.println("Is Palindrome? " + isPalindrome(s3)); // true
    }

    private static boolean isPalindrome(String s1) {
        int left =0;
        int right =s1.length()-1;
        while (left<right){
            char l = s1.charAt(left);
            char r = s1.charAt(right);
            if(!Character.isLetterOrDigit(l)){
                left++;
            }
            else if(!Character.isLetterOrDigit(r)){
                right--;
            }
            else{
                if(Character.toLowerCase(l)!=Character.toLowerCase(r)){
                    return false;
                }
                left ++;
                right --;
            }

        }

        return true;
    }
}

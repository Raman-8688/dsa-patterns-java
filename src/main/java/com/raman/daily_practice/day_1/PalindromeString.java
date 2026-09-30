package com.raman.daily_practice.day_1;

public class PalindromeString {

    public static void main(String args[]){
        String str = "sas";
        System.out.println("given string is palindrome:"+palindromeCheck(str));
    }

    public static boolean palindromeCheck(String str){
        int left=0;
        int right=str.length()-1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

}

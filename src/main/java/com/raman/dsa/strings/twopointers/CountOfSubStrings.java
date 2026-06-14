package com.raman.dsa.strings.twopointers;

public class CountOfSubStrings {
    public static void main(String[] args) {



        // Test Case 1
        String s1 = "abc";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + countSubstringsBrut(s1));
        System.out.println("Output: " + countSubstringsOptimal(s1));
        // Expected: 3

        // Test Case 2
        String s2 = "aaa";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + countSubstringsBrut(s2));
        System.out.println("Output: " + countSubstringsOptimal(s2));
        // Expected: 6

        // Test Case 3
        String s3 = "aba";
        System.out.println("\nInput: " + s3);
        System.out.println("Output: " + countSubstringsBrut(s3));
        System.out.println("Output: " + countSubstringsOptimal(s3));
        // Expected: 4

        // Test Case 4
        String s4 = "abba";
        System.out.println("\nInput: " + s4);
        System.out.println("Output Brute: " + countSubstringsBrut(s4));
        System.out.println("Output Optimal: " + countSubstringsOptimal(s4));
        // Expected: 6
    }

    private static int countSubstringsOptimal(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            count+=expand(s,i,i);
            count +=expand(s,i,i+1);
        }
        return count;

    }
    public static int expand(String s,int left,int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            count ++;
            left --;
            right++;

        }
        return count;
    }

    private static  int countSubstringsBrut(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPolindrome(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean isPolindrome(String s,int left,int right){
        while (left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

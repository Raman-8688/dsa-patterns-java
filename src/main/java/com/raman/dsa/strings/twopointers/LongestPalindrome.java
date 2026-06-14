package com.raman.dsa.strings.twopointers;

public class LongestPalindrome {
    public static String longestPalindromeBrut(String s){
        String result=" ";
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPolindrome(s,i,j)==true){
                    if((j-i+1>result.length())){
                        result = s.substring(i,j+1);
                    }
                }
            }
        }
        return result;
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



    public static String longestPalindromeOptimal(String s){
        int n = s.length();
        int start = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);
            int len = Math.max(len2,len1);
            if(len>(end-start)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    public static int expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;

    }


    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println("Brute Force: " + longestPalindromeBrut(s1)); // "bab" or "aba"

        String s2 = "cbbd";
        System.out.println("Brute Force: " + longestPalindromeBrut(s2)); // "bb"

        String s3 = "babad";
        System.out.println("Optimal: " + longestPalindromeOptimal(s3)); // "bab" or "aba"

        String s4 = "cbbd";
        System.out.println("Optimal: " + longestPalindromeOptimal(s4)); // "bb"
    }
}

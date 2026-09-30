package com.raman.daily_practice.day_1;

public class ReverseString {

    public static void main(String args[]){
        String str="Raman";
        reverse(str);
    }

    public static void reverse(String str){
        char[] arr=str.toCharArray();
        int left=0;
        int right=arr.length-1;
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }

        System.out.println("given string "+str+" reverse is :"+new String(arr));



    }
}

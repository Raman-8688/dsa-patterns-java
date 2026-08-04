package com.raman.dsa.binary_search.lowerbound_upperbound;

import java.util.Arrays;

public class FindKthRotation {
    public void rotate1(int[] nums, int k) {
        int n=nums.length;
        for(int i=0;i<k;i++){
            int temp=nums[n-1];
            for(int j=n-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0] = temp;
        }

    }
    public void rotate2(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            int newIndex=(i+k)%n;
            temp[newIndex]=nums[i];

        }
        for(int i=0;i<n;i++){
            nums[i]=temp[i];
        }

    }

    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }

    public static void reverse(int nums[],int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {

        FindKthRotation obj = new FindKthRotation();

        int k = 3;

        // Separate arrays for each method
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};

        // Method 1
        obj.rotate1(nums1, k);
        System.out.println("rotate1: " + Arrays.toString(nums1));

        // Method 2
        obj.rotate2(nums2, k);
        System.out.println("rotate2: " + Arrays.toString(nums2));

        // Method 3 - Optimal
        obj.rotate(nums3, k);
        System.out.println("rotate3: " + Arrays.toString(nums3));
    }
}

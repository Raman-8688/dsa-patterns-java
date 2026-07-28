package com.raman.dsa.binary_search.classsic_binary_search;

public class TargetBinarySearchSimple {
    public static void main(String args[]){
        int[] nums = {1, 3, 5, 7, 9, 11};
        int target = 7;

        int result = BinarySearch(nums, target);

        if(result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found in the array.");
        }
    }

    public static int BinarySearch(int nums[],int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return -1;

    }
}

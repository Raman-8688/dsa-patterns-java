package com.raman.dsa.binary_search.classsic_binary_search;

public class SearchingMinValueInRotatedArray {

    public static void main(String[] args){
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 2, 2, 0, 1};
        int[] nums3 = {11, 13, 15, 17};
        int[] nums4 = {1};

        System.out.println("given Target at :" + searchArray(nums1)); // Expected: 1
        System.out.println("given Target at :" + searchArray(nums2)); // Expected: 0
        System.out.println("given Target at :" + searchArray(nums3)); // Expected: 11
        System.out.println("given Target at :" + searchArray(nums4)); // Expected: 1
    }
    public static int searchArray(int nums[]){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid= left+(right-left)/2;
            if(nums[mid]<=nums[right]) right=mid;
            else left=mid+1;
        }
        return nums[left];

    }
}

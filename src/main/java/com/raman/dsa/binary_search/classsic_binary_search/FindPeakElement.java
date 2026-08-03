package com.raman.dsa.binary_search.classsic_binary_search;

public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement sol = new FindPeakElement();

        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int[] nums3 = {10, 20, 15, 2, 23, 90, 67};

        System.out.println("Peak index in nums1: " + sol.findPeakElement(nums1));
        System.out.println("Peak index in nums2: " + sol.findPeakElement(nums2));
        System.out.println("Peak index in nums3: " + sol.findPeakElement(nums3));
    }
    public int findPeakElement(int nums[]){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>nums[mid+1]) right=mid;
            else left=mid+1;
        }
        return left;

    }
}

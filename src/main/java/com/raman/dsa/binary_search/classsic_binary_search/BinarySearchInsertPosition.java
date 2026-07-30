package com.raman.dsa.binary_search.classsic_binary_search;

public class BinarySearchInsertPosition {

    public static void main(String[] args) {


        int[] nums = {1, 3, 5, 6};

        // Test cases
        System.out.println(searchInsert(nums, 2)); // Expected: 1 (insert before 3)
        System.out.println(searchInsert(nums, 7)); // Expected: 4 (insert at end)
        System.out.println(searchInsert(nums, 5)); // Expected: 2 (found at index 2)
        System.out.println(searchInsert(nums, 0)); // Expected: 0 (insert at start)
    }
    public static int searchInsert(int nums[],int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target) left = mid+1;
            else right=mid-1;
        }
        return left;
    }
}

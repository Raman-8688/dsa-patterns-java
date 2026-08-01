package com.raman.dsa.binary_search.classsic_binary_search;

public class SearchingMinValueInRotatedArray {

    public static void main(String[] args){
        int nums[]={4,5,6,7,1,2,3};
        int nums1[]={4,5,6,7,0,1,2,3};
        int nums2[]={2,3,4,5,6,7,8,1};
        int nums3[]={5,6,7,1,2,3,4};

        System.out.println("given Target at :"+searchArray(nums));
        System.out.println("given Target at :"+searchArray(nums1));
        System.out.println("given Target at :"+searchArray(nums2));
        System.out.println("given Target at :"+searchArray(nums3));
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

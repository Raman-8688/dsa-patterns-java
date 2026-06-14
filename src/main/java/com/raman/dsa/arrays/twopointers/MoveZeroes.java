package com.raman.dsa.arrays.twopointers;

import java.util.Arrays;

public class MoveZeroes {


    public static void moveZeros(int[] nums){
        int n=nums.length;
        int slow=0;
        for(int fast=0;fast<n;fast++){
            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        while(slow<n){
            nums[slow]=0;
            slow++;
        }

    }

    public static void main(String[] args){
        int nums[] = {0, 1, 0, 3, 12};
        System.out.println("Before:"+ Arrays.toString(nums));
        moveZeros(nums);
        System.out.println("Ofter:"+Arrays.toString(nums));

    }
}

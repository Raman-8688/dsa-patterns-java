package com.raman.dsa.twopointers;

import java.util.Arrays;

public class TwoSumTwoPointers {

    public static int[] twoSumEqualToTarget(int nums[],int target){
        int left=0;
        int right=nums.length-1;

       while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return new int[] {nums[left],nums[right]};

            }
            else if(sum<target){
                left++;

            }
            else
            {
                right--;
            }
        }
       return new int[]{};
    }

    public static void main(String args[]){
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSumEqualToTarget(numbers, target);

        System.out.println(Arrays.toString(result));
    }
}

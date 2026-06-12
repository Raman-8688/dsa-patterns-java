package com.raman.dsa.kadane;

public class MaxSubarraySumCircular {

    public static int maxSubarraySumCircularBrute(int nums[]){
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int currentSum=0;
            for(int j=0;j<n;j++){
                currentSum += nums[(i+j)%n];
                maxSum =Math.max(currentSum,maxSum);
            }

        }
        return maxSum;
    }

    public static int maxSubarraySumCircularOptimal(int nums[]){
       int totalSum=0;
       int circularSum=0;
       int maxNormal=kadensMax(nums);
       int minSubArray=kadensMin(nums);
       for(int n:nums) totalSum +=n;
       if(maxNormal<0) return maxNormal;
       circularSum =totalSum-minSubArray;
       return Math.max(maxNormal,circularSum);
    }
    public static int kadensMax(int nums[]){
        int maxSum=nums[0];
        int current=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
           // current += nums[i];
            current = Math.max(nums[i],current+nums[i]);
            maxSum = Math.max(maxSum,current);
            //if(current<0)  current=0;
        }
        return maxSum;
    }
    public static int kadensMin(int nums[]){
        int minSum=nums[0];
        int current=nums[0];
        for(int n:nums){
           /** current +=n;
            or
            */
            current = Math.min(n,current+n);
            minSum=Math.min(minSum,current);
//            if(current>0) current=0;
        }
        return minSum;
    }





    public static void main(String[] args) {
        int[] nums1 = {1, -2, 3,-2}; // Example 1
        int[] nums2 = {5, -3, 5};     // Example 2
        int[] nums3 = {-3, -2, -3};   // Example 3


        System.out.println("Brute Force Results:");
        System.out.println("Example 1: " + maxSubarraySumCircularBrute(nums1));
        System.out.println("\nOptimal Results:");
        System.out.println("Example 1: " + maxSubarraySumCircularOptimal(nums1));
        System.out.println("Brute Force Results:");
        System.out.println("Example 1: " + maxSubarraySumCircularBrute(nums2));
        System.out.println("\nOptimal Results:");
        System.out.println("Example 1: " + maxSubarraySumCircularOptimal(nums2));
        System.out.println("Brute Force Results:");
        System.out.println("Example 1: " + maxSubarraySumCircularBrute(nums3));
        System.out.println("\nOptimal Results:");
        System.out.println("Example 1: " + maxSubarraySumCircularOptimal(nums3));


    }
}

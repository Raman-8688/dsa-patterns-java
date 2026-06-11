package com.raman.dsa.kadane;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        MaximumProductSubArray sol = new MaximumProductSubArray();
        int[] nums = {2, 3, -2, 4};

        // Using Optimized Prefix-Suffix Approach
        int maxProd = sol.maxProductOptimal(nums);
        System.out.println("Maximum Product Subarray (Optimized): " + maxProd);

        // Using Brute Force
        int bruteForceProd = sol.maxProductBruteForce(nums);
        System.out.println("Maximum Product Subarray (Brute Force): " + bruteForceProd);
    }

    private int maxProductBruteForce(int[] nums) {
        int n=nums.length;
        int maxProduct= -10;
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                product *=nums[j];
                maxProduct =Math.max(maxProduct,product);
            }
        }
        return maxProduct;
    }

    private int maxProductOptimal(int[] nums) {
        int n=nums.length;
        int prefix =1;
        int suffix =1;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=nums[i];
            suffix*=nums[n-1-i];
            ans=Math.max(ans,Math.max(prefix,suffix));

        }
        return ans;
    }
}

package com.raman.dsa.prefixsum;

import java.util.HashMap;

public class SubarraySumDivisiblebyK
{
    public static int subArraySumDivisibleByKBruteForce(int nums[],int k){
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum +=nums[j];
                if(sum%k==0){
                    count++;
                }
            }
        }
        return  count;
    }

    public static int optimal(int nums[],int k){
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefix=0;
        for(int n:nums){
            prefix +=n;
            int rem=prefix%k;
            if(rem<0){
                rem+=k;
            }
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
    public static  void main(String[] args){
        int nums[]={4, 5, 0, -2, -3, 1};
        int k=5;
        System.out.println("SubSumDivisibleByK BruteForce:"+subArraySumDivisibleByKBruteForce(nums,k));
        System.out.println("Optimal:"+optimal(nums,k));
    }

}

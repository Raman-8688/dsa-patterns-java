package com.raman.dsa.arrays.twopointers;

public class CountPairs {
    public static void main(String[] args) {

        int[] arr = {1, 5, 7, -1, 5};
        int k = 6;

        System.out.println(countPairs(arr, k));
    }

    private static int countPairs(int[] arr, int k) {
        int left=0;
        int right=arr.length-1;
        int count=0;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==k){
                count++;
                left++;
                right--;
            }
            else if(sum<k){
                left++;
            }
            else{
                right--;
            }
        }
        return count;
    }
}

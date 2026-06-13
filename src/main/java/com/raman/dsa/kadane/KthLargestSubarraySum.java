package com.raman.dsa.kadane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestSubarraySum {
    public static int kthLargestSubArraySumBrut(int nums[],int k){
        ArrayList<Integer> sums=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                sums.add(sum);
            }
        }
        Collections.sort(sums,Collections.reverseOrder());
        return sums.get(k-1);
    }


    public static int kthLargestSum(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Prefix sums
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        // Step 2: Min-heap to store top k sums
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 3: Generate subarray sums using prefix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefix[j + 1] - prefix[i];
                minHeap.add(sum);

                // Keep only k largest
                if (minHeap.size() > k) {
                    minHeap.poll(); // remove smallest
                }
            }
        }

        // Step 4: Root of heap = K-th largest
        return minHeap.peek();
    }
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 1};
        System.out.println(kthLargestSubArraySumBrut(arr1, 2)); // Output: 5
        System.out.println(kthLargestSum(arr1, 2));

        int[] arr2 = {2, 6, 4, 1};
        System.out.println(kthLargestSubArraySumBrut(arr2, 3)); // Output: 11
        System.out.println(kthLargestSum(arr2, 3));
    }
}


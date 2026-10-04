package com.raman.daily_practice.day_3;

import java.util.PriorityQueue;

public class KthLargestUsingPriorityQueue {

    public static void main(String[] args){
        int[] arr={1,3,2,4,8,9,17,1};
        int k = 2;
        System.out.println(k+"th largest number is:"+kthLargest(arr,k));
    }

    public static int kthLargest(int[] arr,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:arr){
            minHeap.add(num);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

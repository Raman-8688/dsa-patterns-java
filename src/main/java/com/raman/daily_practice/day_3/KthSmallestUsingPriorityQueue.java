package com.raman.daily_practice.day_3;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestUsingPriorityQueue {
    public static void main(String[] args){
        int[] arr={2,34,21,3,34,45,9};
        System.out.println("2 second smallest element : "+kthSmallest(arr,2));
    }

    public static int kthSmallest(int[] arr,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: arr){
            maxHeap.add(num);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}

package com.raman.dsa.arrays.slidingwindow;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {

            if (num == 1) {

                currentCount++;

            } else {

                maxCount = Math.max(maxCount, currentCount);

                currentCount = 0;
            }
        }

        return Math.max(maxCount, currentCount);
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 1, 1};

        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
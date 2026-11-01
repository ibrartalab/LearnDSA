package leetcode;

import algorithms.BubbleSort;

public class TwoSum {
    static void main(String[] args) {
        /*
        Problem Statement: LeetCode-1
        You are given an array of integers nums and an integer target,
        return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
         */
        int[] nums = {2,15,11,7};
        int target = 18;
        printResult(twoSumBF(nums,target));
        printResult(twoSumSubOptimal(nums,target));
    }

    // 1. Bruteforce approach
    // TimeComplexity is O(n) and SpaceComplexity is O(1)
    private static int[] twoSumBF(int[] nums, int target){
        // So the first though comes to mind is to iterate over the given array and check
        // each num against all the remaining nums, and repeat this process until we reached last.
        // The outer loop will pick first element and then increment once the inner loop complete his
        // first cycle.
        for (int i = 0; i < nums.length; i++) {
            // j=i+1 because we do not want to recompare the same num again and again
            for (int j = i+1; j < nums.length; j++) {
                if((nums[i] + nums[j]) == target){
                    // Instead of declaring the Array outside the loop
                    // and then assigning indices
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    // 2. Sub-optimal approach
    // TimeComplexity is O(n log n) and SpaceComplexity is O(1)
    private static int[] twoSumSubOptimal(int[] nums, int target){
        // to reduce the TimeComplexity from the previous/above O(n^2) to
        // more efficient O(n log n).

        // first to sort the Array(nums)
        // then apply binary search
        BubbleSort.sort(nums);

        for(int current=0;current < nums.length;current++){
            int left = current + 1;
            int right = nums.length -1;
            int complement = target - nums[current];

            while (left <= right){
                int mid = left + (right - left) / 2;

                if(nums[mid] == complement){
                    return new int[]{current,mid};
                }else if(nums[mid] > complement){
                    right = mid -1;
                } else if(nums[mid] < complement){
                    left = mid + 1;
                }

            }
        }
        return new int[]{};
    }

    // This helper method print the result in a structured format
    private static void printResult(int[] r){
        for (int i:r){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

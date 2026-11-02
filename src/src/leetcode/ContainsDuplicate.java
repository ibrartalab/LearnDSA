package leetcode;

import algorithms.InsertionSort;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    static void main(String[] args) {
        /*
        Problem Statement: LeetCode-217
        Given an integer array nums, return true if any value appears at least twice in the array,
        and return false if every element is distinct.
        */
        int[] nums = {1,2,3,1};
        System.out.println(checkDuplicate(nums));
        System.out.println(checkDuplicateOptimal(nums));
        System.out.println(checkDuplicateSubOptimal(nums));
    }
    // 1. Bruteforce approach
    // TimeComplexity is O(n^2) and SpaceComplexity is O(1)
    private static boolean checkDuplicate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // 2. Sub-optimal approach
    // TimeComplexity is O(n log n) and SpaceComplexity is O(1)
    private static boolean checkDuplicateSubOptimal(int[] nums){
        InsertionSort.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }

    // 2. Optimal approach
    // TimeComplexity is O(n) and SpaceComplexity is O(n)
    private static boolean checkDuplicateOptimal(int[] nums){
        HashSet<Integer> visited = new HashSet<>();

        for (int num:nums) {
            if(visited.contains(num)){
                return true;
            }
            visited.add(num);
        }
        return false;
    }
}

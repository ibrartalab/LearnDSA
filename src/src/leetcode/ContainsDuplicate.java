package leetcode;

public class ContainsDuplicate {
    static void main(String[] args) {
        /*
        Problem Statement: LeetCode-217
        Given an integer array nums, return true if any value appears at least twice in the array,
        and return false if every element is distinct.
        */
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(checkDuplicate(nums));
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
}

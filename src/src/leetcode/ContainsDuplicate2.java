package leetcode;

public class ContainsDuplicate2 {
    static void main(String[] args) {
        /*
        Problem Statement: LeetCode-219
        Given an integer array nums and an integer k, return true if there are two distinct indices i and j
        in the array such that nums[i] == nums[j] and abs(i - j) <= k.
         */
        int[] nums = {1,2,3,1,2,3};
        int[] nums2 = {1,0,1,1};
        int[] nums3 = {1,2,3,1};

        System.out.println(checkDuplicate2BF(nums,2));
        System.out.println(checkDuplicate2BF(nums2,1));
        System.out.println(checkDuplicate2BF(nums3,3));
    }
    // 1. Bruteforce approach
    // TimeComplexity is O(n^2) and SpaceComplexity is O(1)
    private static boolean checkDuplicate2BF(int[] nums, int k){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j] && (j-i) <= k){
                    return true;
                }
            }
        }
        return false;
    }
}

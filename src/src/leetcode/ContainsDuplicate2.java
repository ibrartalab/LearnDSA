package leetcode;

import java.util.HashMap;

public class ContainsDuplicate2 {
    static void main(String[] args) {
        /*
        Problem Statement: LeetCode-219
        Given an integer array nums and an integer k, return true if there are two distinct indices i and j
        in the array such that nums[i] == nums[j] and abs(i - j) <= k.
         */
        int[] t1 = {1,2,3,1,2,3}; // k=2 false
        int[] t2 = {1,0,1,1}; // k=1 true
        int[] t3 = {1,2,3,1}; // k=3 true
        int[] t4 = {0,2,1,3,4,1,1}; // k=1 true

//        System.out.println(checkDuplicate2BF(nums,2));
//        System.out.println(checkDuplicate2BF(nums2,1));
//        System.out.println(checkDuplicate2BF(nums3,3));
        System.out.println(checkDuplicate2Optimal(t1,2));
        System.out.println(checkDuplicate2Optimal(t2,1));
        System.out.println(checkDuplicate2Optimal(t3,3));
        System.out.println(checkDuplicate2Optimal(t4,1));
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
    // 2. Optimal approach - two pointers
    // TimeComplexity is O(n log n) and SpaceComplexity is O(1)
    private static boolean checkDuplicate2Optimal(int[] nums, int k){
        HashMap<Integer,Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!seen.containsKey(nums[i])){
                seen.put(nums[i],i);
            } else if (seen.containsKey(nums[i]) && i - seen.get(nums[i]) <= k) {
                return true;
            }
            seen.put(nums[i],i);
        }
        return false;
    }
}

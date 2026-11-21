package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    static void main(String[] args) {
        /*
        Problem statement: Leetcode-16
        You are given an integer array nums of length n and an integer target.
        Find three integers at distinct indices in nums such that the sum is closest to target.
        Return the sum of the three integers.
        You may assume that each input would have exactly one solution.

        Example:
        Input: nums = [-1,2,1,-4], target = 1
        Output: 2
        Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
         */
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(findClosestSum(nums,target));
    }
    private static int findClosestSum(int[] nums,int target){
        Arrays.sort(nums);
        int bestSum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int currentSum = nums[i]+nums[left]+nums[right];
                if(Math.abs(currentSum-target) < Math.abs(bestSum-target)){
                    bestSum = currentSum;
                }
                if(currentSum == target){
                    return currentSum;
                }else if(currentSum < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return bestSum;
    }
}

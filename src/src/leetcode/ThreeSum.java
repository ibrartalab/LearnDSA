package leetcode;

import algorithms.InsertionSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    static void main(String[] args) {
        /*
        Problem statement: Leetcode-15
        Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
        such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        Notice that the solution set must not contain duplicate triplets.

        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
        Explanation:
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        The distinct triplets are [-1,0,1] and [-1,-1,2].
        Notice that the order of the output and the order of the triplets does not matter.
         */
        int[] t1 = {-1,0,1,2,-1,-4};
        int[] t2 = {0,1,1};
        int[] t3 = {0,0,0};
        int[] t4 = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int[] t5 = {0,0,0,0};
        System.out.println(findThreeSum(t1));
        System.out.println(findThreeSum(t2));
        System.out.println(findThreeSum(t3));
        System.out.println(findThreeSum(t4));
        System.out.println(findThreeSum(t5));
    }
    private static List<List<Integer>> findThreeSum(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return list;
    }
}

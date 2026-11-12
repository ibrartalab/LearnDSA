package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumSumSubarrayDistinct {
    static void main(String[] args) {
        /*
        Problem statement: Leetcode-2461
        Return max sum of distinct subarrays of size k

        You are given an integer array nums and an integer k.
        Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
        1. The length of the subarray is k, and
        2. All the elements of the subarray are distinct.
        3. Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

        A subarray is a contiguous non-empty sequence of elements within an array.
         */
        int[] t1 = {1,5,4,2,9,9,9}; // 15
        int[] t2 = {4,4,4}; // 0
        int[] t3 = {1,2,2}; // 3
        int[] t4 = {1,1,1,7,8,9}; // 24
        int[] t5 = {4,3,3,3,2}; // 0
        int[] t6 = {9,9,9,1,2,3}; // 12

        System.out.println(maxSumBF(t1,3));
        System.out.println(maxSumBF(t2,3));
        System.out.println(maxSumBF(t3,2));
        System.out.println(maxSumBF(t4,3));
        System.out.println(maxSumBF(t5,5));
        System.out.println(maxSumBF(t6,3));
        System.out.println();
        System.out.println(maxSumOptimal(t1,3));
        System.out.println(maxSumOptimal(t2,3));
        System.out.println(maxSumOptimal(t3,2));
        System.out.println(maxSumOptimal(t4,3));
        System.out.println(maxSumOptimal(t5,5));
        System.out.println(maxSumOptimal(t6,3));
    }
    // Bruteforce approach
    private static int maxSumBF(int[] nums,int k){
        int maxSum = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            HashSet<Integer> seen = new HashSet<>();
            int currentSum = 0;
            boolean isValidWindow = true;
            for (int j = i; j <= i+k-1; j++) {
                if (seen.contains(nums[j])){
                    isValidWindow = false;
                    break;
                }
                currentSum += nums[j];
                seen.add(nums[j]);
            }

        if(isValidWindow){
            maxSum = Math.max(maxSum,currentSum);
        }
        }
        return maxSum;
    }
    // Optimal approach
    private static int maxSumOptimal(int[] nums,int k){
        int currentSum = 0;
        int maximumSum = 0;
        HashMap<Integer,Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            seen.put(nums[i],seen.getOrDefault(nums[i],0)+1);
            if(i >= k){
                int outGoing = nums[i-k];
                currentSum -= outGoing;
                seen.put(outGoing,seen.get(outGoing) -1);
                if(seen.get(outGoing) == 0){
                    seen.remove(outGoing);
                }
            }
            if(i >= k-1 && seen.size() == k){
                maximumSum = Math.max(maximumSum,currentSum);
            }
        }
        return maximumSum;
    }
}

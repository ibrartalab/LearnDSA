package leetcode;

public class LongestSubarraySum {
    static void main(String[] args) {
        /*
        Problem statement: Longest Subarray Sum <= K
        Given an array of positive integers and a positive integer k,
        return the length of the longest contiguous subarray whose sum is less than or equal to k.
         */
        int[] nums = {2, 1, 5, 1, 3, 2};
        System.out.println(longSubarraySumLength(nums,7)); // 3

    }
    private static int longSubarraySumLength(int[] nums,int k){
        if(nums == null || k <= 0){
            throw new IllegalArgumentException("Invalid input");
        }
        int left = 0;
        long sum = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k){
                sum -= nums[left];
                left++;
            }
            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}

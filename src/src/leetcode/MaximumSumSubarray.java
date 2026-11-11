package leetcode;

public class MaximumSumSubarray {
    static void main(String[] args) {
        /*
        Problem statement: Maximum Sum Subarray of Size K
        Given an integer array and an integer k, return the maximum sum of any contiguous subarray
        containing exactly k elements.
         */
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSum(nums,k));
    }
    private static int maxSum(int[] nums,int k){
        if(nums == null || k <= 0 || k > nums.length ){
            throw new IllegalArgumentException("Invalid input");
        }
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        int maximumSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i];
            currentSum -= nums[i - k];
            maximumSum = Math.max(maximumSum,currentSum);
        }
        return maximumSum;
    }
}

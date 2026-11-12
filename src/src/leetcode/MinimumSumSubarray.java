package leetcode;

public class MinimumSumSubarray {
    static void main(String[] args) {
        /*
        Problem statement: Minimum sum of subarrays of size k
        Return the minimum sum of any contiguous subarray containing exactly k elements.
         */
        int[] nums = {2, 1, 5, 1, 3, 2}; //6
        int k = 3;
        System.out.println(minSumBF(nums,k));
        System.out.println(minSumOptimal(nums,k));
    }
    // Bruteforce approach
    private static int minSumBF(int[] nums,int k){
        int currentSum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(k+i <= nums.length){
                currentSum -= currentSum;
                for (int j = i; j < k+i; j++) {
                    currentSum += nums[j];
                }
            }
            minSum = Math.min(minSum,currentSum);
        }
        return minSum;
    }
    // Optimal approach
    private static int minSumOptimal(int[] nums,int k){
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        int minSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i];
            currentSum -= nums[i-k];
            minSum = Math.min(minSum,currentSum);
        }
        return minSum;
    }
}

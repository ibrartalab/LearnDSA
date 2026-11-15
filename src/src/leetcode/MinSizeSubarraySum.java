package leetcode;

public class MinSizeSubarraySum {
    static void main(String[] args) {
        /*
        Problem statement: Min Size Subarray Sum
        Given an array of positive integers and a positive target, return the minimum length
        of a contiguous subarray whose sum is greater than or equal to the target.
        Return 0 if no such subarray exists.
         */
        int[] t1 = {2, 3, 1, 2, 4, 3};
        int[] t2 = {1, 1, 1, 1, 1, 1, 1};
        int[] t3 = {1, 2, 3, 4, 5};
        System.out.println(minSumSubarrayLength(t1,7)); // 2
        System.out.println(minSumSubarrayLength(t2,11)); // 0
        System.out.println(minSumSubarrayLength(t3,15)); // 5
    }
    private static int minSumSubarrayLength(int[] nums,int target){
        // Input validation
        if(nums == null || target <= 0){
            throw new IllegalArgumentException("Invalid input");
        }
        // we will use two pointers which will moves according to the condition
        int left = 0;
        // track sum of the current window
        long sum = 0;
        // save the minimum length on each iteration
        int minLength = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            // start adding the values
            sum += nums[right];
            // once the sum equal to or greater than the target
            // we have to drop the value on position(pointer left) to shrink
            // the window size, and add the incoming element to the window.
            while (sum >= target){
                // if the current window length is greater than the minlength skip it
                // if the current window size is less and also the sum is equal to target
                // then the condition is now valid break from here and update the minLength
                minLength = Math.min(minLength, right - left + 1);
                // remove the most left element
                sum -= nums[left];
                left++;
            }
        }
        // at the end if minLength is still holding the original value, which means there
        // is no such elements or a valid window which sum up to the target, then return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

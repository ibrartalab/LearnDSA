package algorithms;

public class SlidingWindow {
    static void main() {
        /*
        Sliding Window is a pattern which helps us to write algorithms that efficiently
        process contiguous subsets of data such as subarrays or substrings. its work with
        linear data structures like Array or Lists.
        Instead of recalculating values from scratch for every subset, the algorithm maintains
        a window that moves step by step across the data, and updating the result incrementally.

        Examples:
        Suppose you want to find the maximum sum of 3 consecutive numbers in the array [2, 1, 5, 1, 3, 2]:
        • Initial Window: [2, 1, 5] gives a sum of 8.
        • Slide 1: Subtract 2 (leaving) and add 1 (entering) to get [1, 5, 1] = 7.
        • Slide 2: Subtract 1 and add 3 to get [5, 1, 3] = 9 (New Maximum).
        • Slide 3: Subtract 5 and add 2 to get [1, 3, 2] = 6.

        Two Main Types:
        1. Fixed-Size Sliding Window:
             The window maintains a constant length (K) as it moves across the data.
             Both the left and right boundaries shift forward together by one step at a time.
             This is commonly used to find the maximum sum or average of K consecutive elements.
        2. Variable-Size (Dynamic) Sliding Window:
             The window expands and shrinks dynamically based on specific conditions.
             You advance the right pointer to expand the window until a condition is met or violated,
             then advance the left pointer to shrink it back into a valid state. This is ideal for finding
             the longest or shortest substring that meets a rule (such as a substring without repeating characters).
         */
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSumSubarray(nums,k);
        System.out.println(result);
    }
    // Fixed-Size Sliding Window
    private static int maxSumSubarray(int[] nums, int k) {
        // Calculate the first window's sum
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        // initially set first window sum as the maxSum
        int maxSum = windowSum;
        // Slide the window
        for (int right = k; right < nums.length; right++) {
            windowSum += nums[right];
            windowSum -= nums[right - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
}

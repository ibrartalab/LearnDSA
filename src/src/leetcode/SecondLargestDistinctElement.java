package leetcode;

public class SecondLargestDistinctElement {
    static void main(String[] args) {
        /*
        Problem statement: Find the second-largest distinct element
        Given an integer array, find its second-largest distinct element.
        Example:
        nums={10, 5, 20, 8, 20} return 10

        The rules for solving this problem are listed below:
        1. You can not sort the array.
        2. Try to solve it within O(n) time complexities.
        3. Handle duplicates and negative numbers.
        4. Decide how to handle arrays without a second-largest distinct element.
         */

        // You have to test all the test cases with the following inputs.
        int[] t1 = {10, 5, 20, 8, 20}; // 10
        int[] t2 = {12, 35, 1, 10, 34, 1}; // 34
        int[] t3 = {5, 5, 5, 5}; // No second-largest distinct element exist
        int[] t4 = {-10, -5, -20, -2}; // -5
        int[] t5 = {-3, 0, 3, 3, -1}; // 0
        int[] t6 = {10, 10, 5, 5, 2}; // 5
        int[] t7 = {7, 2}; // 2
        int[] t8 = {7}; // No second-largest distinct element exist
        int[] t9 = {}; // not a valid input
        int[] t10 = {2, 2, 1}; // 1
        System.out.println(findSecondLargestDistinct(t10));
    }

    private static int findSecondLargestDistinct(int[] nums){
        // Handling all the possible edge cases
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("Array(nums) can not be null or empty");
        }
        if(nums.length == 1){
            throw new IllegalArgumentException("Array(nums) must have present at least two distinct elements.");
        }

        int secondLargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE){
            throw new IllegalArgumentException("All the array elements are same.");
        }
        return secondLargest;
    }
}

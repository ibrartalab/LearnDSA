package leetcode;

import algorithms.TwoPointers;

public class ReverseInPlace {
    static void main() {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
    }
    private static void reverse(int[] nums){
        // We will use the opposite direction two-pointers approach
        // set the left pointer at the beginning of the array
        int left = 0;
        // set the right pointer to the end of the array
        int right = nums.length -1;
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
        printElements(nums);
    }
    // Helper method to traverse over the array and print its element
    private static void printElements(int[] nums){
        for (int num:nums) System.out.print(num + " ");
        System.out.println();
    }
}

package leetcode;

public class MoveZeros {
    static void main(String[] args) {
        /*
        Problem statement: Moves zeros to the end
        Given an integer array, move all zeros to the end while maintaining the relative order of non-zero elements.

        The rules for solving this problem are listed below:
        1. Modify the original array.
        2. Do not create another array. In place modification is allowed.
        3. Preserve the order of non-zero elements.
         */

        int[] t1 = {1, 2, 3, 0, 0}; // 1, 2, 3, 0, 0
        int[] t2 = {1, 2, 3, 4, 5}; // 1, 2, 3, 4, 5
        int[] t3 = {0, 1, 0, 3, 12}; // 1, 3, 12, 0, 0
        int[] t4 = {0, 0, 0, 0}; // 0, 0, 0, 0
        int[] t5 = {1, 2, 3, 0, 0}; // 1, 2, 3, 0, 0
        int[] t6 = {0, 0, 1, 2, 3}; // 1, 2, 3, 0, 0,
        int[] t7 = {0, 1, 0, 2, 0, 3}; // 1, 2, 3, 0, 0, 0
        int[] t8 = {-1, 0, -2, 0, 3}; // -1, -2, 3, 0, 0
        int[] t9 = {0}; // 0
        int[] t10 = {5}; // 5
        int[] t11 = {}; // Not a valid input
//        moveZerosToEnd(nums);
        moveZerosToEndOptimal(t11);
    }
    // 1. Bruteforce approach
    // time complexity O(n^2) and space O(1)
    private static void moveZerosToEnd(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == 0 && nums[j] != 0){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }

    // 2. Optimal approach: using two pointers-same direction
    // time complexity O(n) ans space O(1)
    private static void moveZerosToEndOptimal(int[] nums){
        // Handling some edge cases
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("Array can't be null or empty");
        }
        // track the available space to place non-zero values
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if(nums[right] != 0 && nums[left] == 0){
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            } else if (nums[right] < 0 && left == 0) {
                left++;
            }
            right++;
        }
        printElements(nums);
    }

    // Helper method to traverse over the array and print its element
    private static void printElements(int[] nums){
        for (int num:nums) System.out.print(num + " ");
        System.out.println();
    }
}

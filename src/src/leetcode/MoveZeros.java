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

        int[] nums = {0, 1, 0, 3, 12};
        moveZerosToEnd(nums);
        for (int n:nums){
            System.out.println(n);
        }
    }
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
}

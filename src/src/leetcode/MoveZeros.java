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
        int[] t12 = {1,0,2}; // 1, 2, 0
//        moveZerosToEnd(t3);
//        moveZerosToEndOptimal(t3);
    }
    // 1. Bruteforce approach
    // time complexity O(n^2) and space O(1)
    private static void moveZerosToEnd(int[] nums){
        // We used the java one of the feature called labels.
        // Labels are useful to give names to our individual loop, so that
        // we can easily determine which loop we are referring to.
        Outer:
        for (int i = 0; i < nums.length; i++) {
            Inner:
            if(nums[i] == 0){
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j] != 0){
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break Inner;
                    }
                }
            }

        }
        printElements(nums);
    }

    // 2. Optimal approach: using two pointers-same direction
    // time complexity O(n) ans space O(1)
    private static void moveZerosToEndOptimal2(int[] nums){
        // Handling some edge cases
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("Array can't be null or empty");
        }
        // track the available space to place non-zero values
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
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

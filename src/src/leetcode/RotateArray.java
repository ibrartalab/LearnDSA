package leetcode;

public class RotateArray {
    static void main(String[] args) {
        /*
        Problem statement: Rotate Array to the Right
        Given an integer array and an integer k, rotate the array to the right by k positions.
        Example:
        Input:  [1, 2, 3, 4, 5]
        k = 2
        Output: [4, 5, 1, 2, 3]

        The rules for solving this problem are listed below:
        1. Modify the original array.
        2. Consider cases where k is greater than the array length.
        3. Aim for O(n) time and O(1) auxiliary space.
         */
        int[] nums = {1, 2, 3, 4, 5};
        int k = 10;
        rotateArray(nums,k);
        for (int n:nums){
            System.out.print(n + " ");
        }
    }

    private static void rotateArray(int[] nums, int k){
        /*
        effectiveK is used to track which k elements we should to bring
        to the front from the end of the array.
        But in case the k is greater than nums.length then those k elements
        will be out of index.
        if n=5 and k=7 ,and then we try to rotate/reverse them nums[7] is outOfIndex.
        In that case we get the modules of k = k % n = 7 % 5 = 2
        */
        int effectiveK = k % nums.length;
        // left is pointing to the very first element
        // right is pointing to the last element
        int left = 0;
        int right = nums.length - 1;
        /*
        if effectiveK is 0 or negative then we should return from here.
        because, there is zero rotation required, and also we should save all the rest of
        computation going after this. we do not need to iterate over the array if there is no
        rotation required.
        */
        if(effectiveK <= 0){
            System.err.println("We can't rotate the Array.");
            return;
        }
        // So to fulfill the requirements we need to split the algorithm into 3
        // distinct steps.
        // 1. Reverse the original array in-place
        while (left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
        // 2. Rotate/swap the k elements
        int m = nums[0];
        nums[0] = nums[effectiveK - 1];
        nums[effectiveK - 1] = m;
        // 3. Rotate/swap the rest part of the array.
        int j = nums[effectiveK];
        nums[effectiveK] = nums[nums.length - 1];
        nums[nums.length - 1] = j;
    }
}

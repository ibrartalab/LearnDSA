package leetcode;

import java.util.HashSet;

public class RemoveDuplicates {
    static void main() {
        /*
        Problem statement: Leetcode-26
        Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element
        appears only once. The relative order of the elements should be kept the same.

        Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.

        The first k elements of nums should contain the unique numbers in sorted order.
        The remaining elements beyond index k - 1 can be ignored.
        Custom Judge:

        The judge will test your solution with the following code:
        int[] nums = [...]; // Input array
        int[] expectedNums = [...]; // The expected answer with correct length
        int k = removeDuplicates(nums); // Calls your implementation
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
        }
        If all assertions pass, then your solution will be accepted.

        Example:
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
         */
        int[] n1 = {0,0,1,1,1,2,2,3,3,4};
        int[] n2 = {1,2,2};
        int[] n3 = {1,1,2,3};
        System.out.println(removeDuplicates(n1));
        print(n1);
        System.out.println(removeDuplicates(n2));
        print(n2);
        System.out.println(removeDuplicates(n3));
        print(n3);
    }
    private static void print(int[] nums){
        for (int n:nums) System.out.print(n + " ");
        System.out.println();
    }
    private static int removeDuplicates(int[] nums) {
        int k = nums.length;
        int left = 0;
        int right = 0;
        while (right < nums.length-1){
            if(nums[right] != nums[right+1]){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }else{
                k -= 1;
            }
            right++;

            if(right == nums.length-1){
                nums[left] = nums[right];
            }
        }
        return k;
    }
}

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
        System.out.println(removeDuplicates(new int[]{1,2,2}));
    }
    private static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if(set.contains(nums[right]) && left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                while (left > 0 && nums[left] < nums[left-1]){
                    int t = nums[left];
                    nums[left] = nums[left-1];
                    nums[left-1] = t;
                }
                left++;

            }else{
                set.add(nums[right]);
                k += 1;
                right++;
            }
        }
        for (int i = 0; i < set.size()-1-i; i++) {
            if(nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        return set.size();
    }
}

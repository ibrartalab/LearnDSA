package leetcode;

public class RemoveElement {
    static void main(String[] args) {
        /*
        Problem statement: Remove Element-27
        Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
        The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

        Consider the number of elements in nums which are not equal to val be k, to get accepted,
        you need to do the following things:
        1. Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
           The remaining elements of nums are not important as well as the size of nums.
        2. Return k.

        Example:
        Input: nums = [0,1,2,2,3,0,4,2], val = 2
        Output: 5, nums = [0,1,4,0,3,_,_,_]
         */
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int k = removeElement(nums,val);
        System.out.println(k);
    }
    private static int removeElement(int[] nums,int value){
        int k = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if(nums[right] != value){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                k += 1;
            }
            right++;
        }
        return k;
    }
}

package leetcode;

public class TwoSumSortedArray {
    static void main(String[] args) {
        /*
        Problem statement: Two sum in sorted array
        Given a sorted integer array and a target, determine whether two distinct elements add up to the target.
         */
        int[] nums = {1, 2, 4, 6, 8, 9};
        int target = 11;
        System.out.println(twoSumInSortedArray(nums,target));
    }
    private static boolean twoSumInSortedArray(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            long sum = nums[left] + nums[right];
            if(sum == target){
                return true;
            } else if (sum < target) {
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}

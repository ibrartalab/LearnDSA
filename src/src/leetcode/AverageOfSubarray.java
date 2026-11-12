package leetcode;

public class AverageOfSubarray {
    static void main(String[] args) {
        /*
        Problem statement: Average of every subarray of size k
        Given an integer array and k, return an array containing the average of every
        contiguous subarray of size k.
         */
        int[] nums = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        double[] result = averageSubarray(nums,k);
        for (double re:result){
            System.out.print(re + " ");
        }
    }
    // Bruteforce approach
    private static double[] averageSubarray(int[] nums, int k){
        double[] averages = new double[nums.length - k + 1];
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(k+i <= nums.length){
                sum -= sum;
                for (int j = i; j < k+i; j++) {
                    sum += nums[j];
                }
                double average = (double) (sum / k);
                averages[i] = average;
            }
        }
        return averages;
    }
}

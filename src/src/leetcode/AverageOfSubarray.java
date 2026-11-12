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
        double[] result = averageSubarrayOptimal(nums,k);
        for (double re:result){
            System.out.print(re + " "); // 2.2 2.8 2.4 3.6 2.8
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
    // Optimal solution
    private static double[] averageSubarrayOptimal(int[] nums,int k){
        double[] averages = new double[nums.length - k + 1];
        double sum = 0;

        for (int i = 0; i <= nums.length; i++) {

            if(i >= k){
                if(i-k <= averages.length){
                    double average = sum/k;
                    averages[i-k] = average;
                }
                sum -= nums[i-k];
            }
            if(i <= nums.length -1){
                sum += nums[i];
            }

        }
        System.out.println(sum);
        return averages;
    }
}

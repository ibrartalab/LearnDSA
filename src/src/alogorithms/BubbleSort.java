package algorithms;

public class BubbleSort {
    // This algorithm helps to sort an array.
    // So, the basic idea is to compare an element to its adjacent one
    // if its larger swap them with each other.
    // Larger elements are bubble up to the end of the Array in each pass.
    public static void sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}

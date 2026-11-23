package algorithms;

public class BubbleSort {
    // This algorithm helps to sort an array.
    // So, the basic idea is to compare an element to its adjacent one
    // if its larger swap them with each other.
    // Larger elements are bubble up to the end of the Array in each pass.
    static void main(String[] args) {
        int[] unsortedNums = {2,6,8,4,1,5};
        int[] sortedNums = {1,2,3,4,5,6};
        sort(unsortedNums);
        sortOptimized(sortedNums);
        for (int num:sortedNums){
            System.out.print(num + " ");
        }
    }
    // The normal Bubble Sort Algorithm
    // if we pass an already sorted array, it will still run n^2 times
    // each pass will iterate over n.length-1-i times.
    public static void sort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    // to avoid unnecessary traversing over the already sorted array
    // we should use this once isSwapped condition to terminate the
    // loop on right time. In this prevent the unnecessary iteration
    // which reduce the times complexity to O(n) if the array is already sorted.
    private static void sortOptimized(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < nums.length-1-i; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }
}

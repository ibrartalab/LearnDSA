package algorithms;

public class SelectionSort {
    /*
    The main idea is to select the minimum element in the entire array,
    swap it to the first position, and then, in the next iteration, select the second
    minimum element and swap it with the second position.

    Let's understand this with a simple real-world analogy.
    You are holding a bunch of playing cards and want to sort them.
    As a human, you can look at all the cards, pick the smallest one, place it to the left
    of you to hold, then look for the next smallest.
     */

    public static void sort(int[] nums){
        // The outer loop will keep track of the sorted part
        for (int i = 0; i < nums.length-1; i++) {
            // minIndex is pointing to the min value in the Array
            int minIndex = i;
            // The inner loop will find the min value in the unsorted part
            // of the array. And if we found any element less than nums[minIndex]
            // update minIndex with that position
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            // If the element at nums[minIndex] is already in its correct place
            // then we don't need unnecessary swapping
            if(minIndex != i){
                // After found the most min value from the Array
                // then we will swap it to the i-th position
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}

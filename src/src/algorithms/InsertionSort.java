package algorithms;

public class InsertionSort {
    /*
    We take the first element as a prev, then start second element current.
    compare current with prev, if it's less than we simply shift the element
    until it's correct position inside the sorted part. If it's greater than we simply
    the current element in that position.
     */

    static void main(String[] args) {
        int[] nums = {9,14,15,12,6,8,13};
        sort(nums);
        for (int n:nums){
            System.out.println(n);
        }
    }
    public static void sort(int[] nums){
        // we set i=1 so we can compare it with i-1 the prev element.
        // if we start at index 0, prev will become -1 , and this case will
        // get IndexOutOfBound exception.
        for (int i = 1; i < nums.length; i++) {
            // we need this value to go backward in our Array
            // for shifting, and also helps when to stop the shifting.
            // also we need the currentV(which hold the last state of the current value)
            // which we should place once the shifting has done.
            int currentV = nums[i];
            int prev = i-1;

            while (prev >=0 && currentV < nums[prev]){
                nums[prev + 1] = nums[prev];
                prev--;
            }
            nums[prev+1] = currentV;
        }
    }
}

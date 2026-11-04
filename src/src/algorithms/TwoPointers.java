package algorithms;

public class TwoPointers {
    static void main(String[] args) {
        /*
        Two pointers itself is not an algorithm, but it's a technique used to optimized
        our algorithm from a time complexity of O(n^2) into O(n) time.
        But its also not true, that every O(n^2) algorithm becomes O(n) using two-pointers,
        there are certain cases in which use of two-pointers make sense.

        There are several variation of two-pointer technique, I will try to explain each
        of them one by one.
        */

        /*
        1. Opposite direction pointers
        So we point one pointer to the beginning of the array, and another at the end of the
        array. and both moves toward each other based on certain condition defined in your
        algorithm or the problem statement.
        Example:
        [1,3,5,7,9]
        left = 0 (the first pointer which is pointing to the very first element in the array)
        right = array.length-1 (pointing to the last element of the array)

        Now lets take a scenario in which the sum of the elements such that add up to the target value
        we need to return those numbers, indexes, or return true instead.

        One thing to remember that we can use any name
        for the pointers, and also to know that these are not some special magical things, these are normal
        variable which hold int values pointing to the elements of the array same like the indexes, but
        it's moves and behave based on certain logic.

        If sum of array[left]+array[right] == target, then we will return left,right
        If sum < target, then we will increment left by 1 left++. because we know that the given
        array is sorted and if we move to the right the elements will come larger than the previous onces.
        If sum > target, we will to the oppsite of the above, move right pointer by 1 right--, because
        we need smaller elements to reached to the target.
         */
        int[] nums = {1,3,5,7,9};
        int target = 10;
        printElements(oppositeDirection(nums,target));

        /*
        2. Same direction pointers
        Now in this case both pointers are start at the same positions, but move
        with different speed. May be pointer A move by one at a time and pointer B
        move by two forward or backward direction depending on the logic and problem
        nature.
        Example: Moves zeros to the end of the array
        [0,1,0,3,12]
        Iteration 1:
        Left(track the available space to place non-zero values) = 0 -> 0 and right = 0 -> 0
        If nums[right] != 0 -> ++left, nums[left-1] = nums[right], nums[left] = 0
        If nums[right] < 0 && left == 0 -> left++;
         */
        int[] nums2 = {-1, 0, -2, 0, 3};
        sameDirection(nums2);
        printElements(nums2);
    }

    private static int[] oppositeDirection(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        while (left < right){
            // we stored the sum in a long data type, in case if the sum values
            // goes beyond int limit, so to handle that situation.
            long sum = (long) (nums[left] + nums[right]);

            if(sum == target){
                return new int[]{left,right};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{-1,-1};
    }

    private static void sameDirection(int[] nums){
        // track the available space to place non-zero values
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if(nums[right] != 0 && nums[left] == 0){
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            } else if (nums[right] < 0 && left == 0) {
                left++;
            }
            right++;
        }
    }

    // Helper method to traverse over the array and print its element
    private static void printElements(int[] nums){
        for (int num:nums) System.out.print(num + " ");
        System.out.println();
    }
}

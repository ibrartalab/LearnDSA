package algorithms;

public class PrefixSum {
    static void main(String[] args) {
        /*
        Suppose you are given an array of elements, and then several times asks to calculate
        sum of the elements in a range. So we can simply loop through from starting index into
        ending index and calculate the sum. but the problem with this approach is that each time
        we need to iterate over the array again and again.
        Example:
        {2, 4, 1, 7, 3, 6}
        Index 1 to 3: 4 + 1 + 7 = 12
        Index 2 to 5: 1 + 7 + 3 + 6 = 17
        Index 0 to 4: 2 + 4 + 1 + 7 + 3 = 17

        For one query, this is perfectly reasonable.
        But imagine you have:
        - An array containing 1 million elements.
        - 100,000 range-sum queries.
        Repeatedly traversing the array could require an enormous amount of work.

        Prefix Sum solves this problem by doing some calculations in advance so that future range-sum queries become much faster.
         */
        int[] nums = {2, 4, 1, 7, 3, 6};
        long[] preSum = prefixSum(nums);
        System.out.println(rangeSum(preSum,1,3));// 12
        System.out.println(rangeSum(preSum,2,5));// 17
        System.out.println(rangeSum(preSum,0,4));// 17
    }
    // calculate the prefix sum for the given input array and stored it into a new array, then return it.
    // so that we can easily in O(1) time get the sum for any given range
    private static long[] prefixSum(int[] nums){
        // check whether nums is null or not
        if(nums == null) throw new IllegalArgumentException("Array(nums) can not be null");
        // preSum will store all the pre-calculated sum for each position.
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }
        return preSum;
    }
    // now this function will help to calculate and return range sum between two indexes
    private static long rangeSum(long[] preSum,int left,int right){
        // check whether nums is null or not
        if(preSum == null) throw new IllegalArgumentException("Array(nums) can not be null");
        // check whether the provided range is correct or not
        if(left < 0 || left > right || right >= preSum.length){
            throw new IllegalArgumentException("Invalid range");
        }
        // we check if the range start from the first element upto right, then there is
        // no need to minus the left elements , because there is no left elements
        if(left == 0){
            return preSum[right];
        }
        return preSum[right] - preSum[left - 1];
    }
}

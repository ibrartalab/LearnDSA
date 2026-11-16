package leetcode;

public class MedianTwoSortedArrays {
    static void main() {
        /*
        Problem statement: Leetcode-4
        Given two sorted arrays nums1 and nums2 of size m and n respectively,
        return the median of the two sorted arrays.
        The overall run time complexity should be O(log (m+n)).

        Examples:
        Input: nums1 = [1,3], nums2 = [2]
        Output: 2.00000
        Explanation: merged array = [1,2,3] and median is 2.

        Input: nums1 = [1,2], nums2 = [3,4]
        Output: 2.50000
        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
         */
        int[] nums1 = {1,2}, nums2 = {3,4};
        System.out.println(findMedian(nums1,nums2));
    }
    // Optimal approach using Binary search
    private static double findMedian(int[] nums1,int[] nums2){
        if(nums1.length > nums2.length) return findMedian(nums2,nums1);
        int left = 0;
        int right = nums1.length;
        while (left <= right){
            int mid1 = (left + right) / 2;
            int mid2 = ((nums1.length + nums2.length + 1)/2) - mid1;
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = (mid1 == nums1.length) ? Integer.MAX_VALUE : nums1[mid1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == nums2.length) ? Integer.MAX_VALUE : nums2[mid2];
            if(l1 <= r2 && l2 <= r1){
                if((nums1.length + nums2.length)%2 == 0){
                    return (double) (Math.max(l1,l2) + Math.min(r1,r2))/2;
                } else {
                    return (double) Math.max(l1,l2);
                }
            } else if (l1 > r2) {
                right = mid1 - 1;
            }else {
                left = mid1 + 1;
            }
        }
        return 0.0;
    }
}

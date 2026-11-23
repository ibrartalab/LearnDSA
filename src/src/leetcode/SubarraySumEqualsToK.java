package leetcode;

import datastructures.MyHashMap;

public class SubarraySumEqualsToK {
    static void main(String[] args) {
        /*
        Problem statement: Count the number of valid subarrays whose sum is equals to k
        Given an integer array nums and an int k, return the count of all the valid
        subarrays whose sum is equals to k.
         */
        System.out.println(countValidSubarraySumEqualsK(new int[]{1,1,1},2));//2
        System.out.println(countValidSubarraySumEqualsK(new int[]{1,2,3},3));//2
        System.out.println(countValidSubarraySumEqualsK(new int[]{1, -1, 1, -1},0));//4
        System.out.println(countValidSubarraySumEqualsK(new int[]{3, 2, 1},3));//2
        System.out.println(countValidSubarraySumEqualsK(new int[]{0, 0, 0},0));//6
        System.out.println(countValidSubarraySumEqualsK(new int[]{1, 2, 3},10));//0
        System.out.println(countValidSubarraySumEqualsK(new int[]{1, 2, 1, 2}, 3));//3
        System.out.println(countValidSubarraySumEqualsK(new int[]{-1, -1, 1}, -1));//3
    }
    private static long countValidSubarraySumEqualsK(int[] nums,int k){
        if (nums == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        MyHashMap<Long,Long> map = new MyHashMap<>();
        map.put(0L,1L);
        long count = 0;
        long prefixSum = 0;
        for (int num:nums){
            prefixSum += num;
            long requiredPrefix = prefixSum - k;
            if(map.get(requiredPrefix) != null){
                count += map.get(requiredPrefix);
            }
            if(map.get(prefixSum) == null){
                map.put(prefixSum,1L);
            }else {
                map.put(prefixSum,map.get(prefixSum)+1);
            }
        }
        return count;
    }
}

package leetcode;

import java.util.HashMap;

public class LongestCommonPrefixString {
    static void main(String[] args) {
        /*
        Problem statement: Leetcode-14
        Write a function to find the longest common prefix string amongst an array of strs.
        If there is no common prefix, return an empty string "".
        Example:
        Input: strs = ["flower","flow","flight"]
        Output: "fl"
         */
        String[] s1 = {"flower","flow","flight"};
        String[] s2 = {"reflower","flow","flight"};
        String[] s3 = {"dog","racecar","car"};
        String[] s4 = {"a"};
        String[] s5 = {"","b"};
        System.out.println(findCommonPrefixString(s1));
        System.out.println(findCommonPrefixString(s2));
        System.out.println(findCommonPrefixString(s3));
        System.out.println(findCommonPrefixString(s4));
        System.out.println(findCommonPrefixString(s5));
    }
    private static String findCommonPrefixString(String[] strs){
        if(strs == null){
            throw new IllegalArgumentException("Array(strs) can not be null!");
        }
        String prefixStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int limit = Math.min(prefixStr.length(),strs[i].length());
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < limit; j++) {
                    if(strs[i].charAt(j) == prefixStr.charAt(j)){
                        s.append(strs[i].charAt(j));
                    }else {
                        break;
                    }
            }
            prefixStr = s.toString();
            if (prefixStr.isEmpty()) {
                break;
            }
        }
        return prefixStr;
    }
}

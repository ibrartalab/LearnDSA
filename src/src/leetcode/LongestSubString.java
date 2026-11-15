package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {
    static void main(String[] args) {
        /*
        Problem statement: Longest substring without repeating characters
        Given a string s, find the length of the longest substring without duplicate characters.
        Example:
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
         */
        String s = "abcabcbb"; // 3
        String s1 = "bbbbb";// 1
        String s2 = "pwwkew";// 3
        String s3 = "1R1T7";// 4
        System.out.println(substringLength(s));
        System.out.println(substringLength(s1));
        System.out.println(substringLength(s2));
        System.out.println(substringLength(s3));
    }
    private static int substringLength(String s){
        HashSet<Character> seen = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (seen.contains(ch)){
                seen.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength,right - left + 1);
            seen.add(ch);
        }
        return maxLength;
    }
}

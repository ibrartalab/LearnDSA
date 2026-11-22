package leetcode;

public class LongestPalindromeSubstring {
    static void main(String[] args) {
        /*
        Problem statement: Leetcode-5
        Given a string s, return the longest palindromic substring in s.
         */
//        System.out.println(longestPalindromeString("babad"));
//        System.out.println(longestPalindromeString("cbbd"));
//        System.out.println(longestPalindromeString("ac"));
//        System.out.println(longestPalindromeString("acc"));
//        System.out.println(longestPalindromeString(""));
//        System.out.println(longestPalindromeString("ccc"));
        System.out.println(longestPalindromeString("abbcccba"));
    }
    private static String longestPalindromeString(String s){
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(i,i,s);
            int len2 = expand(i,i+1,s);
            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private static int expand(int left,int right,String s){
            while (left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }else break;
            }
            return right - left - 1;
    }

}

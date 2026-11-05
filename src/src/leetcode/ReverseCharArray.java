package leetcode;

public class ReverseCharArray {
    static void main(String[] args) {
        /*
        Problem statement: Reverse string
        Write a function that reverses a string. The input string is given as an array of characters s.
        You must do this by modifying the input array in-place with O(1) extra memory.

        Examples:
        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
         */
        char[] s = {'h','e','l','l','o'};
        reverseStringArray(s);
    }
    // 1. Optimal solution using two pointers - opposite direction
    private static void reverseStringArray(char[] s){
        int left = 0;
        int right = s.length -1;

        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(s);
    }
}

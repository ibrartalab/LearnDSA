package leetcode;

public class ValidPalindrome {
    static void main(String[] args) {
        /*
        Problem statement: check whether a string is a valid palindrome or not
        Given a String, determine whether it reads the same forward and backward.

        Rules for solving this problem are listed below:
        1. Use two pointers.
        2. Treat uppercase and lowercase as different for now.
        3. Do not use a second reversed String.
         */
        String s1 = "madam"; // true
        String s2 = "racecar"; // true
        String s3 = "hello"; // false
        String s4 = "a"; // true
        System.out.println(isValidPalindrome(s1));
        System.out.println(isValidPalindrome(s2));
        System.out.println(isValidPalindrome(s3));
        System.out.println(isValidPalindrome(s4));

    }
    // 1. Optimal approach using two pointers opposite direction
    private static boolean isValidPalindrome(String str){
        // handle some edge cases
        if(str.isBlank()){
            throw new IllegalArgumentException("Array is empty");
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}

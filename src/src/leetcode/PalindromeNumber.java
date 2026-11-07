package leetcode;

public class PalindromeNumber {
    static void main(String[] args) {
        /*
        Problem statement: Palindrome Number
        Given an integer x, return true if x is a palindrome, and false otherwise.

        Since we already solve many problems on this topic, but those were on a string.
        now how to check either an integer is a palindrome or not.
         */
        int num = 121;
        System.out.println(isPalindromeNumber(num));
    }
    private static boolean isPalindromeNumber(int num){
        // Since we can not iterate over int, so the first thought would be
        // to convert the given int into a string, and then iterate over each char.
        String nStr = String.valueOf(num);
        int left = 0;
        int right = nStr.length()-1;
        while (left < right){
            if (nStr.charAt(left) == nStr.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}

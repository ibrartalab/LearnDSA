package leetcode;

public class ValidPalindromeString {
    static void main(String[] args) {
        /*
        Problem statement: Is a given string a valid palindrome
        A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
        and removing all non-alphanumeric characters, it reads the same forward and backward.
        Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome, or false otherwise.

        Example:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Because after converting into lowercase and removing all non-alphanumeric characters the input will become
        like this "amanaplanacanalpanama" so if you read it from opposite side it will read the same.
         */
        String s = "A man, a plan, a canal: Panama"; // true
        String s1 = "race a car"; // false
        String s2 = ""; // true
        String s3 = " "; // true
        String s4 = "a"; // true
        String s5 = ".,!?"; // true
        String s6 = "0P"; // false
        String s7 = "A1b2b1a"; // true
        String s8 = "12321"; // true

        System.out.println(isValidPalindromeString(s));
        System.out.println(isValidPalindromeString(s1));
        System.out.println(isValidPalindromeString(s2));
        System.out.println(isValidPalindromeString(s3));
        System.out.println(isValidPalindromeString(s4));
        System.out.println(isValidPalindromeString(s5));
        System.out.println(isValidPalindromeString(s6));
        System.out.println(isValidPalindromeString(s7));
        System.out.println(isValidPalindromeString(s8));
    }
    private static boolean isValidPalindromeString(String str){
        // handle edge case, if str is empty or blank simply return true
        if(str.isEmpty()){
            return true;
        }
        // now we get the cleaned version of the string which is only
        // contains alphanumeric characters
        String nStr = cleanStr(str);

        int left = 0;
        int right = nStr.length()-1;
        while (left < right){
            if(nStr.charAt(left) == nStr.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    // this helper method will remove all the non-alphanumeric chars from
    // the provided string/phrase
    private static String cleanStr(String str){
        // use string builder to optimize frequently happened modifications.
        // and then this newly created nStr will return
        StringBuilder nStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // so instead of converting the string outside from the loop
            // will create a new string inside the memory, although in this
            // case we haven't used that normal immutable string, but to avoid
            // those things, and convert on the spot
            char ch = Character.toLowerCase(str.charAt(i));
            // condition 1 will check that the ch should be fallen b/t a to z
            boolean cond1 = ch < 'a' || ch > 'z';
            // condition 1 will check that the ch should be fallen b/t 0 to 9
            boolean cond2 = ch < '0' || ch > '9';
            // if the both the conditions were false then simply skip them
            if(cond1 && cond2){
                continue;
            }else {
                nStr.append(ch);
            }
        }
        return nStr.toString();
    }
}

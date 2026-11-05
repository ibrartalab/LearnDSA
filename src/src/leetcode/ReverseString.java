package leetcode;

public class ReverseString {
    static void main() {
        /*
        Problem statement: Reverse a string
        Given a String, return a new String with its characters in reverse order.
        Rules for solving this problem are listed below:
        1. Do not use StringBuilder.reverse().
        2. Use a character array and your own reversal logic.
        */
        String greet = "hello"; // "olleh"
        String reversed = reverse(greet);
        System.out.println(reversed);
    }
    private static String reverse(String s){
        // convert the given string into a characters array
        char[] chars = s.toCharArray();
        // set the starting index at length-1
        int start = chars.length -1;
        // we use StringBuilder here to achieve a little bit of optimization
        // while reconstructing the new reversed string
        StringBuilder reversed = new StringBuilder();

        while (start >= 0){
            reversed.append(chars[start]);
            start--;
        }
        return reversed.toString();
    }

}

package leetcode;

public class RomanToInteger {
    static void main(String[] args) {
        /*
        Problem statement: Leetcode-13
        Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        For example, 2 is written as II in Roman numeral, just two ones added together.
        12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
        Roman numerals are usually written largest to smallest from left to right.
        However, the numeral for four is not IIII. Instead, the number four is written as IV.
        Because the one is before the five we subtract it making four. The same principle applies to the number nine,
        which is written as IX. There are six instances where subtraction is used:

        Rules:
        I can be placed before V (5) and X (10) to make 4 and 9.
        X can be placed before L (50) and C (100) to make 40 and 90.
        C can be placed before D (500) and M (1000) to make 400 and 900.
        Given a roman numeral, convert it to an integer.
         */
        String s = "III";
        String s1 = "LVIII";
        String s2 = "MCMXCIV";
        String s3 = "MCDLXXVI";
        System.out.println(convertToInt(s));
        System.out.println(convertToInt(s1));
        System.out.println(convertToInt(s2));
        System.out.println(convertToInt(s3));
    }
    private static int convertToInt(String roman){
        int romanIntValue = 0;
        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);
            boolean canSubtract = true;
            if(i > 0){
                char prev = roman.charAt(i-1);
                if(prev == 'I' && ch == 'V'){
                    romanIntValue -= 1;
                    romanIntValue += 4;
                    canSubtract = false;
                } else if (prev == 'I' && ch == 'X') {
                    romanIntValue -= 1;
                    romanIntValue += 9;
                    canSubtract = false;
                }else if (prev == 'X' && ch == 'L') {
                    romanIntValue -= 10;
                    romanIntValue += 40;
                    canSubtract = false;
                }else if (prev == 'X' && ch == 'C') {
                    romanIntValue -= 10;
                    romanIntValue += 90;
                    canSubtract = false;
                }else if (prev == 'C' && ch == 'D') {
                    romanIntValue -= 100;
                    romanIntValue += 400;
                    canSubtract = false;
                }else if (prev == 'C' && ch == 'M') {
                    romanIntValue -= 100;
                    romanIntValue += 900;
                    canSubtract = false;
                }
            }
            if(canSubtract){
                if (ch == 'I') {
                    romanIntValue += 1;
                }else if (ch == 'V') {
                    romanIntValue += 5;
                }else if (ch == 'X') {
                    romanIntValue += 10;
                }else if (ch == 'L') {
                    romanIntValue += 50;
                }else if (ch == 'C') {
                    romanIntValue += 100;
                }else if (ch == 'D') {
                    romanIntValue += 500;
                }else if (ch == 'M') {
                    romanIntValue += 1000;
                }
            }
        }
        return romanIntValue;
    }
}

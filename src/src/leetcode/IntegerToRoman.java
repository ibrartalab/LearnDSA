package leetcode;

import java.util.HashMap;

public class IntegerToRoman {
    static void main(String[] args) {
        /*
        Problem statement: Leetcode-12
        Seven different symbols represent Roman numerals with the following values:
        Symbol	Value
            I	1
            V	5
            X	10
            L	50
            C	100
            D	500
            M	1000
        Roman numerals are formed by appending the conversions of decimal place values from highest to lowest.
        Converting a decimal place value into a Roman numeral has the following rules:
        If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input,
        append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
        If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol,
        for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX.
        Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
        Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10.
        You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
        Given an integer, convert it to a Roman numeral.

        Input: num = 3749
        Output: "MMMDCCXLIX"
        Explanation:
        3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
        700 = DCC as 500 (D) + 100 (C) + 100 (C)
        40 = XL as 10 (X) less of 50 (L)
        9 = IX as 1 (I) less of 10 (X)
        Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
         */
        System.out.println(convertIntoRoman(3749));
        System.out.println(convertIntoRoman(58));
        System.out.println(convertIntoRoman(1994));
    }
    private static String convertIntoRoman(int num){
        String numStr = String.valueOf(num);
        int multi = 0;
        String[] romanStr = new String[numStr.length()];
        for (int i = numStr.length()-1; i >= 0; i--) {
            if(multi < numStr.length()){
                switch (multi){
                    case 0:
                        switch (numStr.charAt(i)){
                            case '0' -> romanStr[multi]="";
                            case '1' -> romanStr[multi]="I";
                            case '2' -> romanStr[multi]="II";
                            case '3' -> romanStr[multi]="III";
                            case '4' -> romanStr[multi]="IV";
                            case '5' -> romanStr[multi]="V";
                            case '6' -> romanStr[multi]="VI";
                            case '7' -> romanStr[multi]="VII";
                            case '8' -> romanStr[multi]="VIII";
                            case '9' -> romanStr[multi]="IX";
                        }
                        break;
                    case 1:
                        switch (numStr.charAt(i)){
                            case '1' -> romanStr[multi]="X";
                            case '2' -> romanStr[multi]="XX";
                            case '3' -> romanStr[multi]="XXX";
                            case '4' -> romanStr[multi]="XL";
                            case '5' -> romanStr[multi]="L";
                            case '6' -> romanStr[multi]="LX";
                            case '7' -> romanStr[multi]="LXX";
                            case '8' -> romanStr[multi]="LXXX";
                            case '9' -> romanStr[multi]="XC";
                        }
                        break;
                    case 2:
                        switch (numStr.charAt(i)){
                            case '1' -> romanStr[multi]="C";
                            case '2' -> romanStr[multi]="CC";
                            case '3' -> romanStr[multi]="CCC";
                            case '4' -> romanStr[multi]="CD";
                            case '5' -> romanStr[multi]="D";
                            case '6' -> romanStr[multi]="DC";
                            case '7' -> romanStr[multi]="DCC";
                            case '8' -> romanStr[multi]="DCCC";
                            case '9' -> romanStr[multi]="CM";
                        }
                        break;
                    case 3:
                        switch (numStr.charAt(i)){
                            case '1' -> romanStr[multi]="M";
                            case '2' -> romanStr[multi]="MM";
                            case '3' -> romanStr[multi]="MMM";
                        }
                        break;
                }
                multi++;
            }
        }
        StringBuilder finalRomanStr = new StringBuilder();
        for (int i = romanStr.length-1; i >=0; i--) {
            finalRomanStr.append(romanStr[i]);
        }
        return finalRomanStr.toString();
    }
}

package leetcode;

public class CountVowels {
    static void main(String[] args) {
        /*
        Problem statement: Count Vowels and Consonants
        Given a String containing English letters, count its vowels and consonants.

        Rules for solving this problem are listed below:
        1. Count both uppercase and lowercase letters.
        2. Ignore spaces, digits, and special characters.
        3. Do not use regular expressions.
         */
        String s1 = "aeiou09 23jj";
        countOfVowelsAndConsonants(s1);
    }
    private static void countOfVowelsAndConsonants(String str){
        // edge case handling for null string
        if(str == null){
            throw new IllegalArgumentException("String str can't be null");
        }
        // these are the variables to track the count of vowels
        // and consonants
        int vowelsCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            // edge cases to handle, if the char is not a vowel and not either
            // a consonant, if it is a digit, space, or special char in that case
            // we should skip them
            if(ch < 'a' || ch > 'z'){
                continue;
            }
            switch (ch){
                case 'a', 'e', 'i', 'o', 'u' -> vowelsCount += 1;
                default -> consonantCount += 1;
            }
        }
        // printing the structured result
        System.out.println("Vowels = " + vowelsCount + "\nConsonant = " + consonantCount);
    }
}

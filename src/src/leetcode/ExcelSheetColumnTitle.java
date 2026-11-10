package leetcode;

public class ExcelSheetColumnTitle {
    static void main(String[] args) {
        /*
        Problem statement: Excel Sheet Column Title
        Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
        Example:
        A->1
        B->2
        C->3
        Z->26
        AA->27
        AB->28
         */
        int columnNumber = 28;
        String columnTitle = convertToTitle(columnNumber);
        System.out.println(columnTitle);
    }
    private static String convertToTitle(int columnNumber){
        // check edge case if the column number is 0 or negative
        // so in that case throw an error, cause there is no title based on <= 0
        if(columnNumber <= 0){
            throw new IllegalArgumentException("columnNumber must be > 0");
        }
        // this alphabets array will help to map our column number to an exact title.
        String[] alphabets = {
                "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        // we use stringBuilder for frequent modification, so that we can save memory
        StringBuilder stringBuilder = new StringBuilder();
        // if the column number is between 1 and 26 which means we do not need the iteration
        // and the formula calculation to find out a number for each title
        if(columnNumber > 26){
            while (columnNumber > 0){
                stringBuilder.append(alphabets[(columnNumber - 1)%26]);
                columnNumber = (columnNumber - 1)/26;
            }
        }else {
            stringBuilder.append(alphabets[columnNumber - 1]);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}

package algorithms;

import java.awt.image.WritableRaster;

public class BSort {
    static void main(String[] args) {
        int[] nums = {5, 2, 8, 1, 3};
        printDesc(5);
        System.out.println(sum(5));
        System.out.println(factorial(5));
    }
    private static void printDesc(int n){
        // base case
        if(n == 0) return;
        // work to do
        System.out.println(n);
        // recursive case
        printDesc(n-1);
    }
    private static int sum(int n){
        // base case
        if(n==0) return 0;
        // recursive case
        return n + sum(n-1);
    }
    private static int factorial(int n){
        // base case
        if (n==0) return 1;
        // recursive case
        return n * factorial(n-1);
    }
}

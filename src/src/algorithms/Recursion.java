package algorithms;

public class Recursion {
    static void main(String[] args) {
        /*
        Recursion is a programming technique where a method call itself to solve
        the smaller part of the same problem by dividing into multiple chunks.

        You will found it similar to loops, but we never replace loops with it,
        instead we use it where it makes more sense to easily and clearly solve
        a particular problem.

        A recursion have two main parts:
        1. Base case: a conditional statement where we stop the recursion.
        2. Recursive case: where the method call itself for going deeper.
        there is might be a third part of the recursion where we do all the work.
         */
        printAsc(5);
    }
    // print number from n-1
    private static void printAsc(int n){
        if(n == 0) return;
        printAsc(n-1);
        System.out.println(n);
    }
}

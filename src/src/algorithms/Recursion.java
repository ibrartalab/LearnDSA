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
        printAsc(5); // 12345
        printDesc(5); // 54321
        System.out.println(sum(5)); // 15
    }
    // print number from n-1
    private static void printAsc(int n){
        if(n == 0) return; // base case
        printAsc(n-1); // recursive case
        System.out.println(n); // work do to
    }
    // print number from n-1 in descending order
    private static void printDesc(int n){
        if (n == 0) return; // base case
        System.out.println(n); // work to do
        printDesc(n-1); // recursive case
    }
    // return sum of the numbers from n-1
    private static int sum(int n){
        if (n == 0) return 0; // base case
        return n + sum(n-1); // recursive case and work done
    }
}

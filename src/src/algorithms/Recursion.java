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
        System.out.println(factorial(5)); // 120
        printElements(new int[]{1,2,3,4,5},-2); // 12345
        System.out.println(sumOfElements(new int[]{1,2,3,4,5},0)); // 15
        System.out.println(findMaxElement(new int[]{100,2,14,8,58},0)); // 14
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
    // return factorial of number n
    private static int factorial(int n){
        if (n == 0) return 1; // base case: for factorial(0) is 1
        return n * factorial(n-1);
    }
    // print elements of an array
    private static void printElements(int[] nums,int index){
        // input validations
        if(nums == null) throw new IllegalArgumentException("Array(nums) can not be null");
        // base case
        if(index < 0 || index == nums.length) return;
        // work to do
        System.out.print(nums[index] + " ");
        // recursive case
        printElements(nums,index+1);
    }
    // return the sum of all the elements in the array
    private static int sumOfElements(int[] nums,int index){
        // input validations
        if(nums == null) throw new IllegalArgumentException("Array(nums) can not be null");
        // base case
        if(index < 0 || index == nums.length) return 0;
        // recursive case and work done
        return nums[index] + sumOfElements(nums,index+1);
    }
    // find max element in an array
    private static int findMaxElement(int[] nums,int index){
        // input validations
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("Array(nums) can not be null or empty");
        }
        if(index < 0 || index >= nums.length){
            throw new IllegalArgumentException("Invalid index");
        }
        // base case
        if(index == nums.length-1) return nums[index];
        // find the max element in the remaining array
        int maxElement = findMaxElement(nums,index+1);
        return Math.max(nums[index],maxElement);
    }
}

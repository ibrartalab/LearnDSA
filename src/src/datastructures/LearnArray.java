package datastructures;

public class LearnArray {
    static void main(String[] args) {
        /*
        Array is part of the linear data structure, which means we can use it to stored data
        in a sequential order. like; [1,2,3,4,5]

        Array has the following properties:
        1. Array are fixed size. during the initializing of the array we must have to tell what will
        be the size of it.
        2. Array stored data in a contiguous nature, means every element will be stored next to each other
        in the memory.
        3. Array is cache friendly. Most of the time we use Array is a helper/cache in others data structures.
        4. Array can be very helpful to implement others data structures, like stack, queue.
        5. Due to its contiguous nature accessing elements in Array are in constant times O(1).
        6. We can access elements by its index, starting from 0 as a first index.

        Drawback of Array:
        1. Array is fixed size, which will be hard handle or required manual works to handle it by resizing
        the original Array.
        2. We can randomly access element very fast, but inserting and deleting element random position could
        be expensive.
         */

        // Syntax
        int[] numbers = new int[5]; // declaration of the int array numbers
        // Assigning values
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // Accessing element by its index
        int num1 = numbers[0];
        System.out.println(num1); // 10

        // We can use foreach loop to traverse at each element
        for (int number:numbers){
            System.out.print(number + " ");
        }

        /*
        Some common complexities:
        Accessing: O(1)-constant time
        Inserting from end: O(1)-constant time
        Inserting randomly: O(n)-linear time
        Deleting from end: O(1)-constant time
        Deleting randomly: O(n)-linear time
        Updating: O(1)-constant time
        Traversing: O(n)-linear time
        Searching: O(n)-linear time using linear search or O(log n)-logarithmic time using Binary Search
         */

    }
}

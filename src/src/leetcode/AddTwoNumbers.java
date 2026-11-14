package leetcode;

import java.util.LinkedList;

public class AddTwoNumbers {
    static void main(String[] args) {
        /*
        Problem statement: 2-Leetcode
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order, and each of their nodes contains a single digit.
        Add the two numbers and return the sum as a linked list.

        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
        Example:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
         */
        // Approach No 1: solving the problem using the original LeetCode problem ListNode
        ListNode listNode1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode listNode2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode result2 = addTwoNumbers1(listNode1,listNode2);

        while (result2 != null){
            System.out.println(result2.val);
            result2 = result2.next;
        }
        // Approach No 2: solving the problem using the Java Collection LinkedList<Integer>
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        LinkedList<Integer> result1 = addTwoNumbers2(list1,list2);
        System.out.println(result1);
    }
    private static ListNode addTwoNumbers1(ListNode l1,ListNode l2){
        ListNode newNodeHead = new ListNode(0);
        ListNode current = newNodeHead;
        int carryN = 0;
        while (l1 != null || l2 != null || carryN != 0){
            int nL1 = (l1 != null) ? l1.val : 0;
            int nL2 = (l2 != null) ? l2.val : 0;

            int sum = nL1 + nL2 + carryN;
            carryN = sum/10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if(l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return newNodeHead.next;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static LinkedList<Integer> addTwoNumbers2(LinkedList<Integer> l1,LinkedList<Integer> l2){
        int length1 = l1.size(),length2 = l2.size();
        int carryN = 0;
        int start = 0;
        int end = length1 < length2 || length1 > length2 ? (Math.abs(length2-length1)) : length1;
        LinkedList<Integer> newNode = new LinkedList<>();
        while (start < end){
            int nL1 = l1.get(start);
            int nL2 = l2.get(start);
            int sum = nL1 + nL2 + carryN;
            int newNodeVal = sum % 10;
            carryN = sum / 10;
            newNode.add(newNodeVal);
            start++;
        }
        return newNode;
    }
}

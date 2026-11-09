package leetcode;

import datastructures.MyHashMap;

public class FirstNonRepeatingChar {
    static void main(String[] args) {
        /*
        Problem statement: Find the first Non-Repeating character
        Given a string s, find the first character that appears exactly once.
        Return its index. If no such character exists, return -1.

        Example:
        Input: "leetcode"
        Output: 0
        'l' is the first character that appears once.
         */
        String s = "leetcode";// 0
        String s1 = "loveleetcode";//2
        String s2 = "aabb";//-1
        int index = firstUniqueChar(s2);
        System.out.println(index);
    }
    private static int firstUniqueChar(String str){
        // to track the current element through the entire loop cycle
        // and store it to this map
        MyHashMap<Character,Integer> map = new MyHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            // if the map has already the element then increment its frequency count
            // if it's not then simply add with initial frequency of 1
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),map.get(str.charAt(i)) + 1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        // walkthrough the str and check whether the first element which has the freq of 1
        // return the index of that one
        for (int i = 0; i < str.length(); i++) {
            int freq = map.get(str.charAt(i));
            if(freq == 1){
                return i;
            }
        }
        return -1;
    }
}

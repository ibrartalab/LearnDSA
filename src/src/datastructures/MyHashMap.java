package datastructures;

import java.util.HashMap;

public class MyHashMap {
    // this array buckets will contain all the nodes for this Map.
    private final Node[] buckets;
    // this is the size of the Map, initially its 0
    private int size;

    public MyHashMap(){
        buckets = new Node[10];
        size = 0;
    }
    // this is the actual Node we need to create
    private static class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    // this helper method hash can calculate and return the index on which
    // we should add our Node inside the buckets array is a bucket,or buckets of linked list
    private int hash(int key){
        return Math.floorMod(key,buckets.length);
    }
    // this method will add a new Node or update an existing one inside the buckets.
    public void put(int key,int value){
        // first we need to get the appropriate index through the hash method
        int index = hash(key);
        // get the currentNode using this index
        Node currentNode = buckets[index];
        // now to check either this currentNode has data or not
        // if currentNode is not null, which means in this particular bucket
        // a Node or Nodes of LinkedList available.
        while(currentNode != null){
                // if the key provided is matching with the key of the
                // currentNode, then we can simply update the value and return from here.
                if(currentNode.key == key){
                    currentNode.value = value;
                    return;
                }
                // if the current bucket has more than one Nodes and the first one
                // has not matched the key then move to the next Node
                currentNode = currentNode.next;
        }
        // else we can simply create a new Node
        Node newNode = new Node(key,value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        // increment the size of the buckets array
        size++;
    }
    // this metho is useful to get the value for the given key
    // if the provided key has a mapping in the Map, so return the value of it.
    public Integer get(int key){
        // first we need to get the appropriate index through the hash method
        int index = hash(key);
        // get the currentNode using this index
        Node currentNode = buckets[index];
        // now check if the currentNode is not null and the currentNode.key is matched to
        // provided key
        while (currentNode != null){
            if(currentNode.equals(key)){
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    // this method will delete the key from the map and its associated value.
}

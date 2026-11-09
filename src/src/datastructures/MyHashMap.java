package datastructures;

import java.util.Objects;

public class MyHashMap<K,V> {
    // this array buckets will contain all the nodes for this Map.
    private Node<K,V>[] buckets;
    // this is the size of the Map, initially its 0
    private int size;
    // the thresholder for the buckets array for resizing
    private static final double MAX_LOAD_FACTOR = 0.75;

    public MyHashMap(){
        buckets = new Node[10];
        size = 0;
    }
    // this is the actual Node we need to create
    private static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    // this helper method hash can calculate and return the index on which
    // we should add our Node inside the buckets array is a bucket,or buckets of linked list
    private int hash(K key){
        int hasCode = (key == null) ? 0 : key.hashCode();
        return Math.floorMod(hasCode,buckets.length);
    }
    // this method will add a new Node or update an existing one inside the buckets.
    public void put(K key,V value){
        // first we need to get the appropriate index through the hash method
        int index = hash(key);
        // get the currentNode using this index
        Node<K,V> currentNode = buckets[index];
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
        // resizing if the current insertion cross the max capacity threshold.
        resize();
        // recalculating the index, in case capacity has changed
        index = hash(key);
        // else we can simply create a new Node
        Node<K,V> newNode = new Node<>(key,value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        // increment the size of the buckets array
        size++;
    }
    // this metho is useful to get the value for the given key
    // if the provided key has a mapping in the Map, so return the value of it.
    public V get(K key){
        // first we need to get the appropriate index through the hash method
        int index = hash(key);
        // get the currentNode using this index
        Node<K,V> currentNode = buckets[index];
        // now check if the currentNode is not null and the currentNode.key is matched to
        // provided key
        while (currentNode != null){
            if(Objects.equals(currentNode.key,key)){
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    // get the key of the specific Node
    public boolean containsKey(K key){
        // first we need to get the appropriate index through the hash method
        int index = hash(key);
        // get the currentNode using this index
        Node<K,V> currentNode = buckets[index];
        while (currentNode != null){
            if(Objects.equals(currentNode.key,key)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }
    // check whether the map contains a specific value
    public boolean containsValue(V value){
        for (MyHashMap.Node<K,V> head: buckets){
            MyHashMap.Node<K,V> currentNode = head;
            while (currentNode != null){
                if(Objects.equals(currentNode.value,value)){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }
    // this method will delete the key from the map and its associated value.
    public void remove(K key){
        // first we need to get the appropriate index through the hash method
        int index = hash(key);
        // get the currentNode using the index in the buckets
        Node<K,V> currentNode = buckets[index];
        // keep track of the previousNode
        Node<K,V> previousNode = null;
        // now check if the currentNode is not null and the currentNode.key is matched to
        // provided key and also if the previousNode is null, which means we have to remove
        // the head Node, else we can look for that specific Node in the linkedList and remove.
        while (currentNode != null){
            if(Objects.equals(currentNode.key,key)){
                if(previousNode == null){
                    buckets[index] = currentNode.next;
                }else{
                    previousNode.next = currentNode.next;
                }
                // decrement the bucket size, and return from here
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }
    // get the size of your Map
    public int size(){
        return this.size;
    }
    // resize the buckets array if it's reached to the max threshold
    private void resize(){
        // calculate load factor against the current threshold
        double loadFac = (double) (this.size + 1) / buckets.length;
        // make a copy of the original/old buckets
        Node<K,V>[] oldBuckets = buckets;
        // check if load factor exceed the limit then double the capacity
        // resize the buckets and call the rehash method to rehash all the
        // entries in the old buckets
        if(loadFac > MAX_LOAD_FACTOR){
            buckets = new Node[oldBuckets.length * 2];
            rehash(oldBuckets);
        }
    }
    // this method is the brain for this data structure, which will takes all the elements from
    // the oldBuckets into the newly resized buckets
    private void rehash(Node<K,V>[] oldBuckets){
        // iterate over the oldBuckets
        for (Node<K,V> head:oldBuckets){
            // start with from the head Node
            Node<K,V> currentNode = head;
            // check whether It's null or not
            while (currentNode != null){
                // if currentNode is not null, then hold the immediate
                // next Node pointer at this point, because later we have to change/update
                // currentNode
                Node<K,V>    nextNode = currentNode.next;
                // calculate the new hash index
                int index = hash(currentNode.key);
                // insert the existing Nodes into the new upgraded buckets
                currentNode.next = buckets[index];
                buckets[index] = currentNode;
                // continue to the linkedList for the remaining Nodes
                currentNode = nextNode;
            }
        }
    }
}

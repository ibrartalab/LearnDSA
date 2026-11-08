package datastructures;

public class MyHashMap {
    // this array buckets will contain all the nodes for this Map.
    private Node[] buckets;
    // this is the size of the Map, initially its 0
    private int size;
    // the thresholder for the buckets array for resizing
    private static final double MAX_LOAD_FACTOR = 0.75;

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
        // resizing if the current insertion cross the max capacity threshold.
        resize();
        // recalculating the index, in case capacity has changed
        index = hash(key);
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
            if(currentNode.key == key){
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    // this method will delete the key from the map and its associated value.
    public void remove(int key){
        // first we need to get the appropriate index through the hash method
        int index = hash(key);
        // get the currentNode using the index in the buckets
        Node currentNode = buckets[index];
        // keep track of the previousNode
        Node previousNode = null;
        // now check if the currentNode is not null and the currentNode.key is matched to
        // provided key and also if the previousNode is null, which means we have to remove
        // the head Node, else we can look for that specific Node in the linkedList and remove.
        while (currentNode != null){
            if(currentNode.key == key){
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
        Node[] oldBuckets = buckets;
        // check if load factor exceed the limit then double the capacity
        // resize the buckets and call the rehash method to rehash all the
        // entries in the old buckets
        if(loadFac > MAX_LOAD_FACTOR){
            buckets = new Node[oldBuckets.length * 2];
            rehash(oldBuckets);
        }
    }

    private void rehash(Node[] oldBuckets){
        // iterate over the oldBuckets
        for (Node head:oldBuckets){
            // start with from the head Node
            Node currentNode = head;
            // check whether It's null or not
            while (currentNode != null){
                // if currentNode is not null, then hold the immediate
                // next Node pointer at this point, because later we have to change/update
                // currentNode
                Node nextNode = currentNode.next;
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

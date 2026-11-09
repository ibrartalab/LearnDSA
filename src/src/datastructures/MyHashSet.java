package datastructures;

public class MyHashSet {
    // so instead of rewriting the entire logic for HashSet here,
    // we will just simply reuse our MyHashMap data structure

    // since we are reusing MyHashMap which stores data/elements in a key-value pair
    // so present will be act is a dummy placeholder value for the MyHashMap, so that
    // we can only store the key of the Map is a value for our HashSet.
    private static final int PRESENT = 0;
    // so to use the functionality of MyHashMap we need an object of it.
    private final MyHashMap map = new MyHashMap();
    // this method will add the value to the MyHashSet, and will implement MyHashMap
    // under the hood.
    public void add(int value){
        map.put(value,PRESENT);
    }
    // this method will check if the value in the MyHashSet exist or not, and will implement MyHashMap
    // under the hood.
    public boolean contains(int value){
       return map.containsKey(value);
    }
    // this method will remove the element from the MyHashSet if its exist, and will implement MyHashMap
    // under the hood.
    public void remove(int value){
        map.remove(value);
    }
    // this method will return the of our  MyHashSet.
    public int size(){
        return map.size();
    }
}

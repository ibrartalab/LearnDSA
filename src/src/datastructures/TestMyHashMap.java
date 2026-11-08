package datastructures;

public class Test {
    static void main(String[] args) {
        // testing MyHashMap datastructure with multiple conditions
        MyHashMap map = new MyHashMap();
        System.out.println(map.size()); // 0
        // insert same hash/index keys to check collision handling
        map.put(12,100);
        map.put(22,200);
        map.put(32,300);
        // now get them one by one
        System.out.println(map.get(12));//100
        System.out.println(map.get(22));//200
        System.out.println(map.get(32));//300
        // check the size in this position
        System.out.println(map.size());//3
        // update an existing Node
        map.put(12,500);
        System.out.println(map.get(12));//500
        // check the size again
        System.out.println(map.size());//3
        // remove head
        map.remove(32);
        System.out.println(map.size());//2
        // insert it back
        map.put(32,400);
        System.out.println(map.get(32));//400
        System.out.println(map.size());//3
        // remove middle Node
        map.remove(22);
        System.out.println(map.size());//2
        // insert it back
        map.put(22,1000);
        map.remove(12);
        System.out.println(map.size());//2
        // get and remove non-existing Node
        map.get(10);
        map.remove(10);
        System.out.println(map.size());//2
        // insert negative key and retrieve
        map.put(-12,900);
        System.out.println(map.get(-12));//900
    }
}

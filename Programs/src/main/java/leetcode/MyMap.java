package leetcode;

import java.util.ArrayList;


public class MyMap<K,V> {

    private ArrayList<MapNode<K,V>> buckets;
    private int capacity;
    private int size;

    public MyMap(){
        capacity = 10;
        size = 0;
        buckets = new ArrayList<>();
        for(int i = 0 ; i < capacity ; i++)
            buckets.add(null);
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }
    public int getCapacity(){
        return this.capacity;
    }
    
    private int getBucketIndex(K key){
        int hashcode = key.hashCode();
        int index = hashcode % capacity;
        return index;
    }

    public V remove(K key){
        int index = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(index);

        MapNode<K,V>prev = null;
        while(head!=null){
            if(head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        if(head==null)
            return null;
        size--;
        if(prev!=null)
            prev.next = head.next;
        else
            buckets.set(index,head.next);
        return head.value;
    }

    public V get(K key){
        int index = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(index);
        while(head!=null){
            if(head.key.equals(key))
              return head.value;
        }
        return null;
    }

    public void add(K key, V value){
        int index = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(index);

        while(head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        MapNode<K,V> newNode = new MapNode(key,value);
        head = buckets.get(index);
        newNode.next = head;
        buckets.set(index,newNode);

        if((1.0*size)/capacity >= 0.7){
            ArrayList<MapNode<K,V>> backup = buckets;
            buckets = new ArrayList<>();
            capacity = 2 * capacity;
            size = 0;
            for(int i = 0 ; i < capacity ; i++)
                buckets.add(null);
            for(MapNode<K,V> node : backup){
                while(node!=null){
                    add(node.key, node.value);
                    node = node.next;
                }
            }

        }
    }
    public static void main(String[] args)
    {
        MyMap<String, Integer>map = new MyMap<>();
        map.add("one",1 );

        map.add("two",2 );
        map.add("three",3 );
        map.add("four",4 );
        map.add("five",5 );
        map.add("six",6);
        System.out.println(map.getCapacity());
        map.add("seven",7 );
        System.out.println(map.getCapacity());
        map.add("eight",8 );
        System.out.println(map.getCapacity());
        map.add("nine",9 );
        map.add("ten",10 );
        map.add("nine",11 );

    }

    @Override
    public String toString() {
        return "leetcode.MyMap{" +
                "buckets=" + buckets +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}

class MapNode<K,V>{
    K key;
    V value;
    MapNode<K,V> next;
    public MapNode(){

    }
    public MapNode(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "leetcode.MapNode{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
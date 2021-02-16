package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    Map<K,CacheNode<K,V>> store;
    CacheNode<K,V> dummyLRU;
    CacheNode<K,V> dummyMRU;
    int capacity;

    public void print(){
        CacheNode<K,V> node = dummyMRU.next;
        while(node!=dummyLRU) {
            System.out.print(node);
            node=node.next;
        }

        System.out.println();
    }

    public static void main(String[] args){
        LRUCache<Integer,String> cache = new LRUCache<>(4);
        cache.insert(1,"One");
        cache.insert(2,"Two");
        cache.insert(3,"Three");
        cache.insert(4,"Four");
        cache.print();
        cache.insert(5,"Five");
        cache.print();

    }

    public LRUCache(int cap) {
        this.store = new HashMap<>();
        this.dummyMRU = new CacheNode<>(null,null,null,null);
        this.dummyLRU = new CacheNode<>(null,null,null,null);
        dummyLRU.prev = dummyMRU;
        dummyMRU.next = dummyLRU;
        this.capacity = cap;
    }

    public V get(K key){
        CacheNode<K,V> node = store.get(key);
        if(node == null)
            return null;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = dummyMRU.next;
        node.prev = dummyMRU;

        dummyMRU.next = node;
        node.next.prev = node;

        return node.value;

    }

    public V insert(K key, V value){
        if(store.containsKey(key))
            return null ;

        CacheNode<K,V> node = new CacheNode<>(key,value,null,null);

        node.next = dummyMRU.next;
        node.prev = dummyMRU;

        dummyMRU.next = node;
        node.next.prev = node;

        store.put(key,node);
        if(store.size() > capacity){
            CacheNode<K,V> toRemove = dummyLRU.next;
            return remove(dummyLRU.prev.key);

        }
        return null;

    }

    public V remove(K key){
        CacheNode<K,V> node = store.get(key);
        if(node == null)
            return null;

        node.prev.next = node.next;
        node.next.prev = node.prev;
        store.remove(key);
        return node.value;


    }
}

class CacheNode<K,V>{
    K key;
    V value;
    CacheNode<K,V> prev ;
    CacheNode<K,V> next;

    public CacheNode(K key, V value, CacheNode<K, V> prev, CacheNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return key + " -> "+ value + " | ";
    }
}

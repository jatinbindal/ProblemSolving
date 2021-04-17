package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    Map<Integer, Node> nodeMap;
    Map<Integer, DLL> freqMap;
    final int capacity;
    int size;
    int minFreq;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();

    }

    public int get(int key) {

        if(capacity == 0)
            return -1;


        Node node = nodeMap.get(key);
        if(node == null)
            return -1;
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {

        if(capacity == 0)
            return;
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            updateNode(node);
            return;
        }
        else{
            size++;
            if(size > capacity){
                DLL minFreqList = freqMap.get(minFreq);
                Node deletedNode = minFreqList.removeLast();
                nodeMap.remove(deletedNode.key);
                size--;
            }

            minFreq = 1;
            Node node = new Node(key , value);
            DLL minFreqList = freqMap.getOrDefault(1 , new DLL());
            minFreqList.addNode(node);
            freqMap.put(1,minFreqList);
            nodeMap.put(key,node);

        }

        //System.out.println(nodeMap +  " " + size);
        //System.out.println("-----");

    }

    public void updateNode(Node node) {
        int curFreq = node.freq;
        DLL curList = freqMap.get(curFreq);
        curList.removeNode(node);

        if (curFreq == minFreq && curList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.addNode(node);
        freqMap.put(node.freq, newList);
    }


    class Node{
        int key, val , freq ;
        Node prev ,  next;
        Node(int k , int v){
            key = k;
            val = v;
            freq = 1;
        }

        public String toString(){
            return "[ " + key + " :  " + val  + " : " + freq + " ]";
        }


    }


    class DLL{
        Node head;
        Node tail;
        int size;
        DLL(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addNode(Node node){
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
            size++;
        }

        public void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        public Node removeLast(){
            if(size>0){
                Node toRemove = tail.prev;
                removeNode(toRemove);
                return toRemove;
            }

            return null;
        }

        public String toString(){
            StringBuilder ans = new StringBuilder();
            Node node = head.next;
            while(node!=tail){
                ans.append(node.toString());
                node = node.next;
            }

            return ans.toString();

        }


    }

}




/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
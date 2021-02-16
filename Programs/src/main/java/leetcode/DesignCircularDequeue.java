package leetcode;

class ListNodeDouble{
    int value;
    ListNodeDouble next;
    ListNodeDouble prev;
    ListNodeDouble(int v){
        value = v;
    }
}
class MyCircularDeque {


    int capacity, size = 0;
    ListNodeDouble front, rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
        front = new ListNodeDouble(-1);
        rear = new ListNodeDouble(-1);
        front.next = rear;
        rear.prev = front;

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(capacity == size)
            return false;
        ListNodeDouble node = new ListNodeDouble(value);
        ListNodeDouble temp = front.next;
        front.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = front;
        size++;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == capacity)
            return false;
        ListNodeDouble node = new ListNodeDouble(value);
        ListNodeDouble temp = rear.prev;
        rear.prev = node;
        node.prev = temp;
        temp.next = node;
        node.next = rear;
        size++;

        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size==0)
            return false;
        front.next = front.next.next;
        front.next.prev = front;

        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size==0)
            return false;
        rear.prev = rear.prev.prev;
        rear.prev.next = rear;

        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size==0)
            return front.value;

        return front.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size==0)
            return rear.value;

        return rear.prev.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {

        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {

        return size == capacity;
    }

    public void print(){
        ListNodeDouble p= front;
        while(p!=null){
            System.out.print(p.value + " ");
            p=p.next;
        }
        System.out.println();
    }
}

/**
 * Your leetcode.MyCircularDeque object will be instantiated and called as such:
 * leetcode.MyCircularDeque obj = new leetcode.MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
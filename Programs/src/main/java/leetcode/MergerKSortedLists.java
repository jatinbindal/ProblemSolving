package leetcode;

import java.util.*;

public class MergerKSortedLists {


        public ListNode mergeKLists(ListNode[] lists) {

            ListNode head;

            if(lists.length==0) return null;
            if(lists.length == 1) return lists[0];

            ListNode dummy = new ListNode(-1);
            ListNode pointer = dummy;

            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for(ListNode node  : lists){
                if(node!=null)
                    pq.offer(node);
            }

            while(pq.size() > 1){
                ListNode smallest = pq.poll();
                pointer.next = smallest;
                pointer = pointer.next;
                if(smallest.next!=null)
                    pq.offer(smallest.next);
            }

            pointer.next = pq.poll();
            return dummy.next;
        }
    }



package leetcode;

/**
 * Definition for singly-linked list.
 * public class leetcode.ListNode {
 *     int val;
 *     leetcode.ListNode next;
 *     leetcode.ListNode(int x) { val = x; }
 * }
 */
class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null) return head;
        ListNode p = head;
        while(p.next!=null){
            if(p.next.val == p.val){
                p.next = p.next.next;
            }

            else{
                p = p.next;
            }
        }

        return head;
    }
}
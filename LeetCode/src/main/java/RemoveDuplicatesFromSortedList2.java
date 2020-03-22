/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatedFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;
        ListNode p = head, pre = dummyHead;

        while(p!=null){
            while(p.next!=null  && p.next.val == p.val)
                p = p.next;

            if(pre.next == p){
                pre = pre.next;

            }
            else{
                pre.next = p.next;

            }
            p=p.next;
        }
        return dummyHead.next;
    }
}
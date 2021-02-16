package leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    }
class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p1 = head;
        ListNode p2 = head;

        if(n==1){
            p2 = p1.next;
            if(p2==null) return null;
            while(p2.next!=null){
                p2=p2.next;
                p1=p1.next;
            }
            p1.next = null;
            return head;


        }

        int count = n-1;
        while(count>0){
            p2 = p2.next;
            count--;
        }



        while(p2.next!=null){
            p2=p2.next;
            p1=p1.next;
        }


        p1.val = p1.next.val;
        p1.next = p1.next.next;

        return head;
    }
}

public class SwapNodesInPairs {
        public ListNode swapPairs(ListNode head) {
            if(head==null || head.next == null) return head;
            ListNode p1 = head;
            ListNode p2 = head.next;
            head = p2;
            p1.next = head.next;
            head.next = p1;
            while(p1.next!=null){
                ListNode temp = p1.next;
                p2 = p1.next;
                if(p2.next==null) return head;
                p2 = p2.next;
                p1.next = p2;
                p1 = temp;
                if(p2.next!=null)
                    p1.next = p2.next;
                else
                    p1.next= null;
                p2.next = temp;
            }
            return head;
        }
    }


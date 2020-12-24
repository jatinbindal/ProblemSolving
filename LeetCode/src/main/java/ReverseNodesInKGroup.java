public class ReverseNodesInKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        public ListNode reverseKGroup(ListNode head, int k) {

            int total = 1;
            ListNode p = head;
            while(p.next!=null){
                p = p.next;
                total++;
            }

            int iterations = total / k;
            int i = 1;
            ListNode dummy = new ListNode(-100);
            ListNode prev = dummy;
            prev.next  = head;
            while(i <= iterations){
                prev = reverseKNodes(prev,k);
                i++;
            }
            return dummy.next;
        }

        public ListNode reverseKNodes(ListNode prev , int k){

            ListNode curr = prev.next;
            ListNode then;
            while(k-- > 1){
                then = curr.next;
                curr.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
            return curr;

        }
    }

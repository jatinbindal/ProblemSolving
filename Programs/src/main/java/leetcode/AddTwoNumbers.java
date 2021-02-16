package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
//Add two numbers represented LL
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class leetcode.ListNode {
     *     int val;
     *     leetcode.ListNode next;
     *     leetcode.ListNode() {}
     *     leetcode.ListNode(int val) { this.val = val; }
     *     leetcode.ListNode(int val, leetcode.ListNode next) { this.val = val; this.next = next; }
     * }
     */

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            Deque<Integer> one = new ArrayDeque<>();
            Deque<Integer> two = new ArrayDeque<>();
            ListNode head = l1;
            while(head!=null){
                one.offerFirst(head.val);
                head= head.next;

            }
            head = l2;
            while(head!=null){
                two.offerFirst(head.val);
                head= head.next;

            }

            int carry = 0;
            ListNode dummy =new ListNode(-1);
            while(one.size() > 0 || two.size()  > 0 || carry!=0 ){
                int a = one.size()>0?one.pollFirst():0;
                int b = two.size()>0?two.pollFirst():0;
                int res = a + b + carry;
                if(res > 9){
                    carry = 1;
                    res = res%10;
                }
                else{
                    carry = 0;
                }

                ListNode digit = new ListNode(res);
                digit.next = dummy.next;
                dummy.next = digit;

            }


            return dummy.next;
        }
    }

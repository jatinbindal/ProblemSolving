import jdk.nashorn.internal.ir.IdentNode;
import org.graalvm.compiler.replacements.IntrinsicGraphBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MergerKSortedLists {


        public ListNode mergeKLists(ListNode[] lists) {

            if(lists.length==0) return null;
            ListNode head;
            int minValue = Integer.MAX_VALUE;
            int minIndex=0;
            HashSet<Integer> nonNull = new HashSet<Integer>();
            for(int i = 0; i < lists.length ; i++){
                if(lists[i]!=null) {
                    nonNull.add(i);
                    if(lists[i].val<minValue){
                        minValue = lists[i].val;
                        minIndex = i;
                    }
                }
            }
            head = lists[minIndex];
            ListNode p = head;
            lists[minIndex] = lists[minIndex].next;
            if(lists[minIndex]==null) nonNull.remove(minIndex);
            while(nonNull.size()>1){
                minValue = Integer.MAX_VALUE;
                for(Integer i : nonNull){
                    if(lists[i].val<minValue){
                        minValue = lists[i].val;
                        minIndex = i;
                    }
                }

                p.next = lists[minIndex];
                p = p.next;
                if(lists[minIndex].next==null){
                    nonNull.remove(minIndex);
                }
            }

            p.next = lists[nonNull.stream().findFirst().get()];
            return head;
        }
    }



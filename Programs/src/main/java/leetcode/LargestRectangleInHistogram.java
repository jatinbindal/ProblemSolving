package leetcode;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {


    // keeping 2 stacks : for keeping starting piostion and height resp
    //push bigger rectangles than top
    //if rect is smaller, calculate its total area using pos and ht in stacks
        public int largestRectangleArea(int[] heights) {

            int n = heights.length;
            int i = 1 ;
            int max = 0;
            if(n==0) return max;
            ArrayDeque<Integer> pos = new ArrayDeque<>();
            ArrayDeque<Integer> ht = new ArrayDeque<>();
            pos.addLast(0);
            ht.addLast(heights[0]);

            while(i<n){
                int startPos = i;
                while(!ht.isEmpty() && heights[i]<ht.getLast()){
                    startPos = pos.pollLast();
                    max = Math.max(max , ht.pollLast() * (i - startPos));
                }
                ht.addLast(heights[i]);
                pos.addLast(startPos);
                i++;

            }
            while(!ht.isEmpty()){
                max = Math.max(max ,  ht.pollLast() * (i - pos.pollLast()));
            }
            return max;
        }
    }
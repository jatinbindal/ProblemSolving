package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    //approach 1 : divide into blocks of size k from left and right
    // res = max of right[windowStart] , left[windowEnd]
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int numOfWin = n - k + 1;
            int[] left = new int[n];
            int[] right = new int[n];
            int[] result = new int[numOfWin];
            left[0] = nums[0];
            right[n-1] = nums[n-1];
            for (int i = 1; i < n; i++) {
                if (i % k == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = left[i-1] > nums[i] ? left[i-1] : nums[i];
                }
                int j = n - i - 1;
                if (j % k == k - 1) {
                    right[j] = nums[j];
                } else {
                    right[j] = right[j+1] > nums[j] ? right[j+1] : nums[j];
                }
            }
            for (int i = k - 1, j = 0; i < n; i++, j++) {
                result[j] = left[i] > right[j] ? left[i] : right[j];
            }
            return result;
        }

        //approach 2: Deque, pop from start if index is not in window, pop from end if candidate is smaller than current cand
        public int[] maxSlidingWindowDeque(int[] nums, int k) {

            int n = nums.length;
            int[] res = new int[n-k+1];
            Deque<Integer> q = new ArrayDeque<>();
            int j = 0;
            for(int i = 0 ; i  < n ; i++){
                while(!q.isEmpty() && q.peek()<i-k+1)
                    q.poll();
                while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                    q.pollLast();
                q.offer(i);
                if(i>=k-1)
                    res[j++] = nums[q.peek()];

            }
            return res;
        }
    }


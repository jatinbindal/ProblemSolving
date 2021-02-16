package leetcode;

import java.util.PriorityQueue;
// running median
public class FindMedianFromDataStream {
    class MedianFinder {
        double med = 0;
        PriorityQueue<Integer> leftMax = new PriorityQueue<>((a, b) -> b - a);

        PriorityQueue<Integer> rightMin = new PriorityQueue<>();


        public void addNum(int no) {
            //insert
            if (leftMax.size() == 0 || no < leftMax.peek()) {
                leftMax.offer(no);
            } else {
                rightMin.offer(no);
            }

            //Rebalance
            if (leftMax.size() - rightMin.size() > 1) {
                rightMin.offer(leftMax.poll());
            }
            if (rightMin.size() - leftMax.size() > 1) {
                leftMax.offer(rightMin.poll());
            }

        }

        public double findMedian() {
            if (leftMax.size() == rightMin.size()) {
                med = (leftMax.peek() + rightMin.peek()) / 2.0;
            } else {
                if (leftMax.size() > rightMin.size())
                    med = leftMax.peek();
                else
                    med = rightMin.peek();
            }
            return med;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

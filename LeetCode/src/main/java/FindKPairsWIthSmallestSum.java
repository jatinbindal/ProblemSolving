import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
//Using min heap
//Kth smallest element in a sorted matrix
public class FindKPairsWIthSmallestSum {
    class Tuple implements Comparable<Tuple>{
        int x,y,sum;
        Tuple(int x,int y, int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

        public int compareTo(Tuple that){
            return this.sum - that.sum;
        }
    }
        public List<List<Integer>> kSmallestPairs(int[] n, int[] m, int k) {
            List<List<Integer>> res = new ArrayList();
            if(n.length ==0 || m.length ==0 ) return res;

            PriorityQueue<Tuple> q = new PriorityQueue<Tuple>();

            for(int j = 0 ;  j  < m.length ; j++ )
                q.offer(new Tuple(0,j,n[0]+m[j]));

            int iter = Math.min(k,n.length*m.length);
            while(iter-->0){
                Tuple t = q.poll();
                List<Integer> curr = new ArrayList();

                curr.add(n[t.x]);
                curr.add(m[t.y]);
                res.add(curr);
                if(t.x==n.length-1) continue;
                q.offer(new Tuple(t.x+1,t.y,n[t.x+1]+m[t.y]));

            }
            return res;
        }
    }


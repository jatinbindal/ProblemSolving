import java.util.*;

public class TopKFrequencyWords {

        public List<String> topKFrequent(String[] words, int k) {

            HashMap<String,Integer> count = new HashMap<>();

            PriorityQueue<String> heap = new PriorityQueue<>((one, two) -> {
                int a = count.get(one);
                int b = count.get(two);
                return a==b ? two.compareTo(one) : a - b;
            });

            for(String word : words){
                count.put(word,count.getOrDefault(word, 0 ) + 1);
            }
            for(String word : count.keySet()){
                heap.add(word);
                if(heap.size()>k)
                    heap.poll();
            }


            List<String> ans = new ArrayList();
            while (!heap.isEmpty()) ans.add(heap.poll());
            Collections.reverse(ans);
            return ans;

        }
    }

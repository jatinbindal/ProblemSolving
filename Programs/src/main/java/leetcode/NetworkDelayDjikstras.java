package leetcode;

import java.util.*;

public class NetworkDelayDjikstras {

        public int networkDelayTime(int[][] times, int n, int k) {

            Map<Integer, List<Node>> graph = new HashMap();
            for(int i = 1 ; i<= n; i++)
                graph.put(i, new ArrayList<>());
            for(int[] row  : times){
                int u = row[0] , v = row[1] , w = row[2];
                graph.get(u).add(new Node(v,w));
            }


            return djikstras(graph, n , k);
        }


        public int djikstras(Map<Integer,List<Node>> graph,  int n , int k){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n+1];
            int[] distance = new int[n+1];
            Arrays.fill(distance, Integer.MAX_VALUE);

            pq.add(new Node(k,0));
            distance[k] = 0;
            int result = 0;


            int count  = 0;
            while(!pq.isEmpty() && count < n){
                Node best = pq.poll();
                int u = best.val;
                int cost = best.cost;
                if(visited[u]) continue;

                visited[u] = true;

                result = Math.max(result, cost);

                for(Node child :  graph.get(u)){
                    int temp = cost +  child.cost;

                    if(!visited[child.val] && temp < distance[child.val]){
                        pq.offer(new Node(child.val , temp));
                        distance[child.val] = temp;
                    }
                }
                count++;
            }

            for(int i = 1 ; i < distance.length; i++){
                int d = distance[i];
                if(d == Integer.MAX_VALUE)
                    return -1;
            }
            return result;

        }
    }



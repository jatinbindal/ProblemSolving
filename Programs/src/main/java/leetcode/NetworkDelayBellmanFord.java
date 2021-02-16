package leetcode;

public class NetworkDelayBellmanFord {

        public int networkDelayTime(int[][] times, int N, int K) {

            //BellmanFord
            //for every node
                //  for every edge
                    // keep updating

            int visited[] = new int[N+1];
            for(int i = 1 ; i < N+1 ; i++){
                visited[i] = Integer.MAX_VALUE;
            }

            visited[K] = 0;

            for(int allNodes = 0 ; allNodes < N ; allNodes++){
                for(int i = 0 ; i < times.length ; i++){
                    int u = times[i][0], v = times[i][1] , w = times[i][2];

                    if(visited[u]!=Integer.MAX_VALUE)
                        visited[v] = Math.min(visited[v],visited[u] + w);
                }
            }


            int max = 0;
            for(int i =1 ;i < N+1;i++){
                max = Math.max(max,visited[i]);
            }

            return max==Integer.MAX_VALUE? -1 : max;


        }
    }

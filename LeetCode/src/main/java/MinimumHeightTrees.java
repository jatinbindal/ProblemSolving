import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//like topological sort
//keep trimming leave node
//last 2or1 nodes ins the ans

class MinimumHeightTrees {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) return Arrays.asList(0);

            ArrayList<Integer> adjlist[] = new ArrayList[n];
            ArrayList<Integer> leaves  =new ArrayList<Integer>();
            for (int i = 0; i < n; i++){
                adjlist[i] = new ArrayList();
            }
            int indegree[]  = new int[n];
            for (int[] edge: edges){
                adjlist[edge[0]].add(edge[1]);
                adjlist[edge[1]].add(edge[0]);
                indegree[edge[0]]++;
                indegree[edge[1]]++;
            }
            for (int i = 0; i < n; i++)
                if (indegree[i] == 1) leaves.add(i);

            ArrayList temp;
            while(n > 2){
                temp = new ArrayList<Integer>();
                for (Integer v: leaves){
                    for (Integer parent: adjlist[v]){
                        indegree[parent]--;
                        if (indegree[parent] == 1) temp.add(parent);
                    }
                }
                n -= leaves.size();
                leaves = temp;
            }
            return leaves;
        }
    }
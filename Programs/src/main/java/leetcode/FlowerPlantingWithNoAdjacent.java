package leetcode;

import java.util.ArrayList;
import java.util.List;
//leetcode.Graph coloring Problem with 4 colors
//leetcode.Solution always exists for this problem
public class FlowerPlantingWithNoAdjacent {

        public int[] gardenNoAdj(int n, int[][] paths) {

            int[] results = new int[n];
            List<Integer>[] graph = new ArrayList[n];
            for(int i = 0 ; i < n ; i++){
                graph[i]= new ArrayList<>();
            }

            for(int[] path : paths){
                int one = path[0] , two = path[1];
                graph[one-1].add(two-1);
                graph[two-1].add(one-1);
            }

            for(int i = 0 ; i < n; i++){
                if(results[i]!=0)
                    continue;
                dfs(i,results,graph);
            }
            return results;
        }

        public void dfs(int node,int[] results, List<Integer>[] graph){

            int color = 1;
            while(color<=3){
                if(isValid(color,results,graph[node])){
                    break;
                }
                color++;
            }

            results[node] = color;
            for(int neighbor : graph[node]){
                if(results[neighbor]==0)
                    dfs(neighbor,results,graph);
            }
        }

        public boolean isValid(int color,int[] results,List<Integer> neighbors){
            for(int n : neighbors){
                if(results[n] == color)
                    return false;
            }
            return true;
        }
    }


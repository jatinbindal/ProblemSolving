import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimsAlgorithm {

    static int prims(int n, int[][] edges, int start) {
        Graph g = new Graph(n);
        for(int[] edge : edges){
            g.addEdge(edge[0]-1,edge[1]-1,edge[2]);
        }

        HeapNode[] forHeap= new HeapNode[n];
        boolean flag[] = new boolean[n];
        int[] parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            forHeap[i] = new HeapNode(i, Integer.MAX_VALUE);
            parent[i] = -1;
            flag[i] = false;
        }
        flag[start-1] = true;
        forHeap[start-1].key = 0;
        TreeSet<HeapNode> q = new TreeSet<>((a,b)->a.key - b.key);
        int res = 0;
        for (int i = 0; i < n; i++)
            q.add(forHeap[i]);

        while(!q.isEmpty()){
            HeapNode curr = q.pollFirst();
            flag[curr.vertex] = true;
            res+=curr.key;

            for(Path p : g.adj[curr.vertex]){

                if(!flag[p.dest] && forHeap[p.dest].key > p.wt){
                    q.remove(forHeap[p.dest]);
                    forHeap[p.dest].key = p.wt;
                    q.add(forHeap[p.dest]);
                    parent[p.dest] = curr.vertex;
                }
            }
        }

        return res;
    }

}
class HeapNode {
    int vertex;
    int key;
    HeapNode(int v ,int k ){
        vertex = v ; key = k;
    }
}

class Graph{
    int v;
    LinkedList<Path>[] adj;
    Graph(int e)
    {
        v= e;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int src, int dest, int weight)
    {

        Path one = new Path(dest, weight);
        Path two = new Path(src, weight);
        this.adj[src].addLast(one);
        this.adj[dest].addLast(two);
    }
}
class Path{
    int dest, wt;
    Path(int d , int w){
        dest = d ; wt = w ;
    }
}


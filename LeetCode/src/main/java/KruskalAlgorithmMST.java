import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithmMST {

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edges = new ArrayList<>();
        for(int i = 0 ; i <gFrom.size() ; i++ ){
            edges.add(new Edge(gFrom.get(i)-1 , gTo.get(i)-1 , gWeight.get(i)));
        }
 
        Collections.sort(edges,(a, b)->a.wt - b.wt);
        QuickUnion qu = new QuickUnion(gNodes);
        int e = 0, cost = 0;
        while(e < gNodes - 1){
            for(Edge edge : edges){
                if(qu.unite(edge.from,edge.to)){
                    e++;
                    cost+=edge.wt;
                }
            }
        }
        return cost;
    }
}
class QuickUnion{
    int[] root;
    int[] size;
    QuickUnion(int t){
        root =  new int[t];
        size = new int[t];
        for(int i = 0 ; i < t ; i++){
            root[i] = i;
            size[i] = 1;
        }

    }

    public int findRoot(int i){
        if( i == root[i])
            return i;
        return root[i] = findRoot(root[i]);
    }
    public boolean findCycle(int p, int q){
        return findRoot(p) == findRoot(q);
    }

    public boolean unite(int p , int q){
        int i = findRoot(p);
        int j = findRoot(q);
        if(i==j)
            return false;
        if(size[i] < size[j]){
            root[i] = j ; size[j]+=size[i];
        }
        else{
            root[j] = i ; size[i]+=size[j];
        }
        return true;
    }
}
class Edge{
    int from,to,wt;
    public Edge(int f, int t, int w){
        from = f;to = t; wt=w;
    }
}


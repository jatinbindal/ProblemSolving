import java.util.ArrayList;

//cyclic graph
//topological sort
//Scheduling problem
class CourseSchedule2 {

    int ind = 0;
    public int[] findOrder(int n, int[][] p) {

        int[] result = new int[n];

        ArrayList<Integer>[] map  =  new ArrayList[n];
        for(int i = 0 ; i < n ; i++)
            map[i] = new ArrayList<>();

        for(int[] row : p){
            map[row[0]].add(row[1]);
        }


        int[] visited  = new int[n];
        for(int i = 0;i < n ;  i++){
            if(visited[i]==2) continue;
            if(topologicalIsCyclic(i,map,visited,result))
                return new int[0];
        }

        return  result;
    }

    public boolean topologicalIsCyclic(int n, ArrayList<Integer>[] map , int[] v,int[] result){

        if(v[n]==1) return true ;
        if(v[n]==2) return false;
        v[n] = 1;
        Pi        if(v[n]==2) continue;
                if(topologicalIsCyclic(i,map,v,result))
                    return true;
            }
        }

        v[n] = 2;
        result[ind++] = n;
        return false;

    }
}
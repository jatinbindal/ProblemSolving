package leetcode;

import java.util.HashMap;


//Disjoint class optimized with path compression(find) and size based rank(union)
class LargestComponentSizeByCommonFactor {
        public int largestComponentSize(int[] A) {

            HashMap<Integer,Integer> map = new HashMap<>();
            DSU dsu = new DSU(A.length);
            for(int i =  0 ; i  < A.length ; i++){
                for(int factor = 2 ;  factor*factor <= A[i] ; factor++){
                    if(A[i]%factor == 0){
                        if(map.containsKey(factor))
                            dsu.union(i, map.get(factor));
                        else
                            map.put(factor,i);

                        if(map.containsKey(A[i]/factor))
                            dsu.union(i, map.get(A[i]/factor));
                        else
                            map.put(A[i]/factor,i);
                    }
                }
                if(A[i]>1){
                    if(map.containsKey(A[i]))
                        dsu.union(i, map.get(A[i]));
                    else
                        map.put(A[i],i);
                }
            }

            return dsu.max;


        }
    }

    class DSU{
        int[] parent, size;
        int max ;
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            max = 1;
            for(int i = 0 ; i  < n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i){
            if(parent[i]==i)
                return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int a, int b){
            a  = find(a);
            b = find(b);
            if(a!=b){
                if(size[a] < size[b]){
                    int temp = a ;
                    a= b;
                    b = temp;
                }
                parent[b] = a;
                size[a]+=size[b];
                max = Math.max(max,size[a]);
            }
        }
    }


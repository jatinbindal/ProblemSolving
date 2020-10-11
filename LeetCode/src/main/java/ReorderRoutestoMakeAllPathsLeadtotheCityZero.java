public class ReorderRoutestoMakeAllPathsLeadtotheCityZero {

        public int minReorder(int n, int[][] connections) {

            boolean[] canVisit = new boolean[n]; //Can visit city 0;

            canVisit[0] = true;

            int count = 0;
            int left = n-1;

            while(left>0){
                for(int i = 0; i<connections.length; i++){
                    if(!canVisit[connections[i][0]] && canVisit[connections[i][1]]){
                        canVisit[connections[i][0]] = true;
                        left--;
                    }
                    else if(!canVisit[connections[i][1]] && canVisit[connections[i][0]]){
                        count++;
                        left--;
                        canVisit[connections[i][1]]=true;
                    }
                }
            }
            return count;
        }
    }

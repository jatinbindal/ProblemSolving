public class GasStation {

        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sumGas = 0, sumCost = 0;
            for(int i = 0 ; i  < gas.length ; i++){
                sumGas+=gas[i];
                sumCost+=cost[i];

            }

            if(sumGas<sumCost) return -1;
            sumGas = 0 ; sumCost = 0;
            int ind = -1;
            for(int i = 0 ; i < gas.length ; i++){
                sumCost = cost[i];
                sumGas+=gas[i];
                if(sumGas<sumCost){
                    //reset
                    sumGas = 0;
                    ind = -1;
                }
                else{
                    sumGas-=sumCost;
                    if(ind == -1) ind = i;
                }

            }
            return ind;
        }

    }
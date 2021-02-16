package leetcode;

public class UtilizationChecks {

    public static void main(String[] args){
        int[] utils = {5,10,80};
        finalInstances(1,utils);
    }
        public static int finalInstances(int instances, int[] averageUtil) {


            int i = 0;
            while(i < averageUtil.length){

                if (averageUtil[i] <  25){
                    instances = (instances + 1)/2;
                    i=i+11;
                }
                else if(averageUtil[i] > 60){
                    instances = instances * 2;
                    i = i+11;
                }
                else
                    i+=1;
            }

            return instances;
        }
    }

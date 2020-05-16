public class MaximumSumCircularArray {
        public int maxSubarraySumCircular(int[] num) {


            int max = Integer.MIN_VALUE ;
            int curr = 0;
            int min = Integer.MAX_VALUE;
            int currMin = 0;
            int total = 0;
            for(int i : num){
                curr = Math.max(i,i+curr);

                max = Math.max(max,curr);
                currMin = Math.min(i,i+currMin);
                min = Math.min(min,currMin);
                total+=i;
            }
            return max>0?Math.max(max,total-min):max;


        }
    }

package leetcode;

public class KnapsackDP01 {
    public int calculate(int val[], int[] wt, int W){

//least space and time hacckerrank accepted sol
        int []dp = new int[W+1];

        // iterate through all items
        for(int i=0; i < wt.length; i++)
            //traverse dp array from right to left
            for(int j = W; j >= wt[i]; j--)
                dp[j] = Math.max(dp[j] , val[i] + dp[j - wt[i]]);
        return dp[W];
    }

}

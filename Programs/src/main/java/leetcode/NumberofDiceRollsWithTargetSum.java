package leetcode;

public class NumberofDiceRollsWithTargetSum {
        public int numRollsToTarget(int d, int f, int target) {

            if(d*f<target) return 0;

            int m = (int)(Math.pow(10,9))+7;
            long[][] dp = new long[d][target+1];

            for(int j = 1 ; j<=target  ; j++){
                if(j>f)
                    break;
                dp[0][j] = 1;
            }

            for(int i = 1; i<d ; i++){
                for(int j = 2 ; j<=target ; j++){
                    for(int l = 1 ; l<=f ; l++){
                        if(j-l>0){
                            dp[i][j]+=dp[i-1][j-l];
                        }
                        else
                            break;
                    }
                    dp[i][j]%=m;
                }
            }

            return (int)dp[d-1][target]%m;
        }
    }


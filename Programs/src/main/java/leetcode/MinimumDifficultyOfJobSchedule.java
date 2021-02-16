package leetcode;

public class MinimumDifficultyOfJobSchedule {

    //dp solution
    // tle without memo
        public int minDifficulty(int[] jobs, int d) {

            int n = jobs.length;
            if(n<d) return -1;
            int[][] memo = new int[n][d+1];
            return dfs(jobs,0,d,memo);


        }

        public int dfs(int[] jobs, int ind, int days, int[][] memo){
            if(days==1){
                if(memo[ind][days]==0)
                    memo[ind][days]  = max(jobs, ind, jobs.length-1);
                return memo[ind][days];
            }


            int range = jobs.length - days;
            int result = Integer.MAX_VALUE;
            int max = 0;
            for(int i = ind ; i<=range ;i++){
                max = Math.max(max, jobs[i]);
                if(memo[i+1][days-1]==0)
                    memo[i+1][days-1]  = dfs(jobs, i+1, days-1, memo);
                result = Math.min(result , max + memo[i+1][days-1] );
            }
            return result;

        }

        public int max(int[] jobs, int i, int j){
            int max = 0;
            for(int ind = i ; ind <= j ; ind++){
                max = Math.max(max,jobs[ind]);
            }

            return max;
        }
    }

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {

        public int findNumberOfLIS(int[] nums) {

            //n2 dp solution
            int n = nums.length ;
            if(n == 0) return 0;
            int[] length = new int[n];
            int[] count = new int[n];
            Arrays.fill(length,1);
            Arrays.fill(count,1);
            int lis = 1;
            for(int i = 1 ; i < n ; i++){
                for(int j = 0 ; j  < i  ; j++){
                    if(nums[j]<nums[i]){
                        if(length[j]+1 > length[i]){
                            length[i] = length[j]+1;
                            count[i] = count[j];
                        }
                        else if(length[j] + 1 == length[i]){
                            count[i]+=count[j];
                        }
                    }
                }
                lis = Math.max(length[i],lis);
            }
            int ans=0;
            for(int i = 0 ; i < n ; i++){
                if(length[i]==lis){
                    ans+=count[i];
                }
            }
            return ans;
        }
    }

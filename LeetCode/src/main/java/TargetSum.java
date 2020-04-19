import java.util.Arrays;

public class TargetSum {
        public static int findTargetSumWays(int[] nums, int S) {


            int sum  = 0,zero=0;
            for(int i = 0 ; i < nums.length ; i++){
                sum+=nums[i];
                zero = nums[i]==0?zero+1:zero;
            }
            Arrays.sort(nums);
            int diff =  sum  - S;
            int count  = 0;
            count += calculate(nums,diff,0,count,zero);
            int result = (int)Math.pow(2,zero) * count;

            return result;
        }


        public static int calculate(int[] nums, int diff, int sum , int count, int ind){
            if(diff == sum){
                return ++count;
            }

            for(int i = ind ; i < nums.length ; i++ ){
                if(sum+nums[i]*2>diff) return count;
                sum+=nums[i]*2;
                count=calculate(nums,diff,sum,count,i+1);
                sum-=nums[i]*2;

            }
            return count;
        }
    }

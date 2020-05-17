import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        //n square
        /*if(nums.length == 0 ) return 0;
        int[] less = new int[nums.length];
        less[0] = 0 ;
        int max = 0;
        for(int i = 1 ; i  < nums.length;i++){
            int  count = 0;
            for(int j = 0 ; j < i; j++){
                if(nums[j]<nums[i]) {
                    count = Math.max(count,less[j]+1);
                }
            }
            less[i]=count;
            max = Math.max(max,count);
        }
        return max+1;
        */

            //solitare patience algorithm

            List<Integer> piles = new ArrayList();

            for(int x  : nums){
                int s = 0 , e  = piles.size();
                while(s<e){
                    int mid = s + (e-s)/2;
                    int val = piles.get(mid);
                    if(val<x)
                        s = mid + 1;
                    else
                        e = mid;
                }

                //System.out.println(s);
                if(s==piles.size()) piles.add(x);
                else
                    piles.set(s,x);

            }
            return piles.size();
        }
    }


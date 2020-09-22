import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

        // for occurence > n/3.. only 2 candidates are possible
        // using voting method below
        public List<Integer> majorityElement(int[] nums) {

            List<Integer> res = new ArrayList<>();
            if(nums.length==0)
                return res;
            int cand1 = nums[0],cand2 = Integer.MIN_VALUE;
            int count1 = 1 , count2 = 0;
            for(int i = 1 ; i < nums.length ; i++){
                if(nums[i] == cand1)
                    count1++;
                else if(nums[i] == cand2)
                    count2++;
                else if(count1 == 0) {
                    count1++;
                    cand1 = nums[i];
                }
                else if(count2 == 0){
                    count2++;
                    cand2 = nums[i];
                }
                else{
                    count1--;count2--;
                }
            }

            count1 = 0 ; count2=0;
            for(int n : nums){
                if(n==cand1)
                    count1++;
                else if(n==cand2)
                    count2++;
            }

            if(count1>nums.length/3)
                res.add(cand1);
            if(count2>nums.length/3)
                res.add(cand2);
            return res;
        }
    }

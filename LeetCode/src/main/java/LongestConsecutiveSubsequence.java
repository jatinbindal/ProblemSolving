import java.util.HashMap;
//Longest consecutive seq that can be formed using the numbers
// strictly O(n)tri;
public class LongestConsecutiveSubsequence {

        public int longestConsecutive(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
            int max=0,pre=0;
            for(int number:nums){
                if(map.containsKey(number))
                    continue;
                int right = map.getOrDefault(number+1,0);
                int left = map.getOrDefault(number-1,0);
                int sum = left + right + 1;
                if(left>0)
                    map.put(number-left, sum);
                if(right>0)
                    map.put(number+right, sum);
                map.put(number,sum);
                max = Math.max(sum,max);
            }
            return max;
        }
    }

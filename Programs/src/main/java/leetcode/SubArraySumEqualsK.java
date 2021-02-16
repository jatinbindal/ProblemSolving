package leetcode;

import java.util.HashMap;


//cumulative sum techniue
// 1 1 1
// 1 2 3 if difference of curr cumulative - target is already present in map, increase count
public class SubArraySumEqualsK {
    public class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0, sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
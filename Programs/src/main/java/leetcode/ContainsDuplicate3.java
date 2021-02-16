package leetcode;

import java.util.HashMap;

class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if(nums == null || nums.length == 0) return false;

            HashMap<Long,Long> buckets = new HashMap<>();
            int i = 0;
            long tLong = (long)t;
            for(long n : nums){
                long bucket = n/(tLong+1);
                if(n<0) bucket--;

                if(buckets.containsKey(bucket))
                    return true;

                Long left = buckets.get(bucket-1);
                if(left!=null && n-left<=tLong)
                    return true;

                Long right = buckets.get(bucket+1);
                if(right!=null && right-n <=tLong)
                    return true;

                buckets.put(bucket,n);
                if(buckets.size()>k)
                    buckets.remove(nums[i-k]/(tLong+1));
                i++;


            }

            return false;

        }
    }


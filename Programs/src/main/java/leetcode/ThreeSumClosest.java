package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {

        int result = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length-2; i++){
            int j = i+1,k=nums.length-1,tempSum;
            while(j<k && j<nums.length-1 && k<nums.length) {
                tempSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(tempSum - target) < Math.abs(result - target)) result = tempSum;
                if (tempSum == target) return tempSum;
                else if (tempSum < target) {
                    while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
                    j++;
                } else {
                    while (k > j && nums[k] == nums[k - 1]) k--;
                    k--;
                }
            }
        }
        return result ;
    }
}

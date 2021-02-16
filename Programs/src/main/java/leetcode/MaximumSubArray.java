package leetcode;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        //DP solution Kadane's Algo
        int max = nums[0];
        int maxEndingHere = nums[0];
        for(int i= 1; i < nums.length ; i++){

            maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]);
            max = Math.max(max,maxEndingHere);
        }
        return max;
    }
}

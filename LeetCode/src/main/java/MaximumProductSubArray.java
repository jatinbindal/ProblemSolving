public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {

        //DP solution Kadane's Algo
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i= 1; i < nums.length ; i++){
            if(nums[i]<0){
                int temp = min;
                min = max;
                max = temp;
            }

            min = Math.min(nums[i], min*nums[i]);
            max = Math.max(nums[i], max*nums[i]);

            result = Math.max(result,max);

        }
        return result;
    }
}
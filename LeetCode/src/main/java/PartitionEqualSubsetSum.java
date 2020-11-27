public class PartitionEqualSubsetSum {

    //sum of subset
    //recurive + memo
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        Boolean[][] memo = new Boolean[nums.length + 1][sum + 1];

        return calculate(nums, 0, sum, 0, memo);
    }

    public boolean calculate(int[] nums, int ind, int target, int sum, Boolean[][] memo) {
        if (sum == target) {
            memo[ind][sum] = true;
            return true;
        }
        if (ind == nums.length || sum > target)
            return false;
        if (memo[ind][sum] != null)
            return memo[ind][sum];

        boolean res = calculate(nums, ind + 1, target, sum + nums[ind], memo) || calculate(nums, ind + 1, target, sum, memo);
        memo[ind][sum] = res;
        return res;
    }
}





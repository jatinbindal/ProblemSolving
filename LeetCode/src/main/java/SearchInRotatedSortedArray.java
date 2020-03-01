public class SearchInRotatedSortedArray {

    /*
    *    https://leetcode.com/problems/search-in-rotated-sorted-array/
    * */
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;

            /*
            * Either Left or Right Array will be sorted
            * */
            if (nums[m] <= nums[r]) { //right array is sorted
                if (nums[m] < target && nums[r] >= target) {
                     //target is in right array
                    l = m + 1;
                } else {
                    //target is not in right aray
                    r = m - 1;
                }
            } else if (nums[m] >= nums[l]) { // opposite
                if (nums[m] > target && nums[l] <= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        //Edge case
        if (l == r && nums[l] == target) return l;
        return -1;
    }
}

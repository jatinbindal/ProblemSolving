package leetcode;

public class FindFirstAndLastPositionOfElementsInSortedArray {
    //binary search
    //upper bound  and lower bound, can be combined in one function but its cleaner this way
        public int[] searchRange(int[] nums, int target) {

            int[] res = {-1, -1};
            int left = lowerBound(nums, target);
            if (left != -1) {
                res[0] = left;
                res[1] = upperBound(nums, target);
            }
            return res;


        }

        public int upperBound(int[] nums, int target) {
            int s = 0, e = nums.length - 1;
            int ans = -1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    s = mid + 1;
                } else if (nums[mid] > target)
                    e = mid - 1;
                else
                    s = mid + 1;
            }

            return ans;
        }

        public int lowerBound(int[] nums, int target) {
            int s = 0, e = nums.length - 1;
            int ans = -1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (nums[mid] == target) {
                    ans = mid;
                    e = mid - 1;
                } else if (nums[mid] > target)
                    e = mid - 1;
                else
                    s = mid + 1;
            }

            return ans;
        }


    }

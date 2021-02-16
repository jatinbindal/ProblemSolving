package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNodeWithLeftCount {
    int val;
    TreeNodeWithLeftCount left;
    TreeNodeWithLeftCount right;
    int leftCount = 0;


    TreeNodeWithLeftCount(int v) {
        val = v;
    }

}
public class CountOfSmallerNumberAfterSelf {

        public List<Integer> countSmaller(int[] nums) {

            int n = nums.length;
            if (n == 0) return new ArrayList<>();

            Integer res[] = new Integer[nums.length];
            res[n - 1] = 0;
            TreeNodeWithLeftCount root = new TreeNodeWithLeftCount(nums[n - 1]);
            for (int i = nums.length - 2; i >= 0; i--) {
                int count = insertAndReturnCount(root, nums[i], 0);
                res[i] = count;
            }

            return Arrays.asList(res);

        }

        public int insertAndReturnCount(TreeNodeWithLeftCount node, int val, int curr) {

            if (val <= node.val) {
                node.leftCount++;
                if (node.left != null)
                    return insertAndReturnCount(node.left, val, curr);
                node.left = new TreeNodeWithLeftCount(val);
                return curr;
            } else {
                if (node.right != null)
                    return insertAndReturnCount(node.right, val, curr + 1 + node.leftCount);
                node.right = new TreeNodeWithLeftCount(val);
                return curr + 1 + node.leftCount;
            }
        }
    }




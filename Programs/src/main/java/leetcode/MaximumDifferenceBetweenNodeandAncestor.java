package leetcode;

public class MaximumDifferenceBetweenNodeandAncestor {
    /**
     * Definition for a binary tree node.
     * public class leetcode.TreeNode {
     * int val;
     * leetcode.TreeNode left;
     * leetcode.TreeNode right;
     * leetcode.TreeNode() {}
     * leetcode.TreeNode(int val) { this.val = val; }
     * leetcode.TreeNode(int val, leetcode.TreeNode left, leetcode.TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    //find min and max of each subtree
        int diff = 0, min = 100001, max = 0;

        public int maxAncestorDiff(TreeNode root) {
            calculate(root);
            return diff;
        }

        public int[] calculate(TreeNode node) {

            int[] left = new int[]{node.val, node.val};
            int[] right = new int[]{node.val, node.val};
            if (node.left != null) {
                left = calculate(node.left);
            }
            if (node.right != null) {
                right = calculate(node.right);
            }
            int[] minmax = new int[2];
            minmax[0] = Math.min(left[0], right[0]);
            minmax[1] = Math.max(left[1], right[1]);
            int temp = Math.max(Math.abs(minmax[0] - node.val), Math.abs(minmax[1] - node.val));
            diff = Math.max(diff, temp);

            minmax[0] = Math.min(minmax[0], node.val);
            minmax[1] = Math.max(minmax[1], node.val);
            return minmax;
        }
    }


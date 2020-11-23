
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    //Tree based dp
    public class HouseRobber3 {
        public int rob(TreeNode root) {
            int[] ans = calculate(root);
            return Math.max(ans[0], ans[1]);

        }

        public int[] calculate(TreeNode node) {
            if (node == null)
                return new int[]{0, 0};

            int[] left = calculate(node.left);
            int[] right = calculate(node.right);

            int[] my = new int[2];
            int include = node.val + left[1] + right[1];
            int notInclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            my[0] = Math.max(include, notInclude);
            my[1] = notInclude;
            return my;
        }
    }

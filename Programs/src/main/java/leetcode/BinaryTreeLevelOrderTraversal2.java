package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class leetcode.TreeNode {
 *     int val;
 *     leetcode.TreeNode left;
 *     leetcode.TreeNode right;
 *     leetcode.TreeNode() {}
 *     leetcode.TreeNode(int val) { this.val = val; }
 *     leetcode.TreeNode(int val, leetcode.TreeNode left, leetcode.TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        LinkedList<List<Integer>> res = new LinkedList();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList();
            while(size-->0){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            res.addFirst(temp);
        }
        return res;
    }
}
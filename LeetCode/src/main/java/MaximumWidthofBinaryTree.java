import java.util.LinkedList;
import java.util.Queue;

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
class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qIndex = new LinkedList<>();
        int max = 0;
        q.add(root);
        qIndex.add(1);

        while(!q.isEmpty()){
            int size = q.size();
            int start = 0,end = 0;
            int i = 0 ;
            while(i < size){
                TreeNode curr = q.remove();
                int ind = qIndex.remove();
                if(i==0) start = ind;
                if(i==size - 1) end = ind;
                if(curr.left!=null){
                    q.add(curr.left);
                    qIndex.add(ind*2);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                    qIndex.add(2*ind + 1);
                }
                i++;

            }
            if(max < (end-start+1)) max = end - start + 1;
        }
        return max;
    }
}
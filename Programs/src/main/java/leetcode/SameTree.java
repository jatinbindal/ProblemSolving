package leetcode;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return inOrder(p,q);

    }

    public boolean inOrder(TreeNode p, TreeNode q){
        if((p==null) != (q==null)) return false;

        if((p==null) && (q==null)) return true;

        if(p.val!=q.val) return false;

        if(!inOrder(p.left,q.left)) return false;

        if(!inOrder(p.right,q.right)) return false;

        return true;

    }
}
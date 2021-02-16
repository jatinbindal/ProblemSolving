package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
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

        public int pathSum(TreeNode root, int sum) {

            Map<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            return countSubArrays(root,0,sum,map);
        }

        //Use cumulative sum property
        //thinking :
        // 1 1 1 sum = 2
        // 1 2 3 cumulative

        public int countSubArrays(TreeNode node, int curr, int sum,Map<Integer,Integer> map ){
            if(node == null) return 0;
            curr+=node.val;
            int count = map.getOrDefault(curr - sum,0);
            map.put(curr,map.getOrDefault(curr,0)+1);
            count += countSubArrays(node.left,curr,sum,map) + countSubArrays(node.right,curr,sum,map);
            map.put(curr,map.get(curr)-1);
            return count;
        }


    /*

    Traverse each node and calculate all posiibilities, very expensive, TLE
    public void traverse(leetcode.TreeNode node,int sum,List<List<Integer>> res,   List<Integer> ans){
        if(node == null) return;
        sum(node,0,sum,res,ans);
        traverse(node.left,sum,res,new ArrayList<Integer>());
        traverse(node.right,sum,res,new ArrayList<Integer>());

    }

    public void sum(leetcode.TreeNode node, int curr, int sum,List<List<Integer>> res,List<Integer> ans){
        if (node == null) return;
        curr+=node.val;
        ans.add(node.val);

        if(sum==curr)
            res.add(new ArrayList(ans));

        sum(node.left, curr,sum,res,ans);
        sum(node.right,curr,sum,res,ans);
        ans.remove(ans.size()-1);
    }
    */
    }

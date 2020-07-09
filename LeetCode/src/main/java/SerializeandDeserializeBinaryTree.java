import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    private static final String spliter = ",";
    private static final String NN = "X";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();

    }
    public void buildString(TreeNode node, StringBuilder sb){
        if(node == null)
            sb.append(NN).append(spliter);
        else{
            sb.append(node.val).append(spliter);
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(q);
    }

    public TreeNode buildTree(Deque<String> q){
        String s = q.remove();
        if(s.equals(NN)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = buildTree(q);
        node.right = buildTree(q);
        return node;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
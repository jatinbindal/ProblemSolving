import java.util.Arrays;

public class SerializeAndDeserializeBST {




        public static final String delimiter=",";
        int curr = 0; //used in deserialization

        // Encodes a tree to a single string.

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root,sb);
            return sb.toString();
        }

        public void buildString(TreeNode node, StringBuilder sb){
            if(node==null)
                return;

            String val = Integer.toString(node.val);
            sb.append(val).append(delimiter);
            buildString(node.left,sb);
            buildString(node.right,sb);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if(data.length()==0) return null;
            String[] temp = data.split(delimiter);
            int[] candidates = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();
            return buildTree(candidates,Integer.MIN_VALUE,Integer.MAX_VALUE);

        }
        public TreeNode buildTree(int[] candidates, int min, int max){
            if(curr>=candidates.length) return null;
            int val = candidates[curr];
            if(val < min || val > max){
                curr--;
                return null;
            }
            else{
                TreeNode node = new TreeNode(val);
                curr++;
                node.left = buildTree(candidates,min,node.val);
                curr++;
                node.right = buildTree(candidates,node.val,max);
                return node;
            }
        }
    }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
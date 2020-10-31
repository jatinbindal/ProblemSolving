import java.util.*;

public class CloneGraph {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

        public Node cloneGraph(Node node) {
        // dfs solution
            if(node == null)
                return node;
            Map<Node,Node> map = new HashMap<>();
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            while(!q.isEmpty()){
                int size = q.size();
                while(size-->0){
                    Node og = q.poll();
                    Node my = map.getOrDefault(og,new Node(og.val));
                    map.put(og,my);
                    my.neighbors = new ArrayList<>();
                    for(Node child : og.neighbors){
                        Node myChild;
                        if(map.containsKey(child))
                            myChild = map.get(child);
                        else{
                            myChild = new Node(child.val);
                            q.add(child);
                            map.put(child,myChild);
                            myChild.neighbors = new ArrayList<>();
                        }
                        my.neighbors.add(myChild);
                    }
                }
            }

            return map.get(node);

        }
    }





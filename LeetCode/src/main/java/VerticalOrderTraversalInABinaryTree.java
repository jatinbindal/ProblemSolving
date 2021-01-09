import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//vertical order traversal
//diameter or girth similar concept
public class VerticalOrderTraversalInABinaryTree {

        java.util.List<Triplet> nodeList = new ArrayList<>();

        public List<java.util.List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> output = new ArrayList<>();

            if(root == null){
                return output;
            }

            DFS(root , 0 ,0 );

            Collections.sort(nodeList);

            List<Integer> currColumn = new ArrayList();
            Integer currentColIndex = nodeList.get(0).column;

            for(Triplet triplet : nodeList){

                Integer column = triplet.column;
                Integer value = triplet.value;

                if(currentColIndex == column){
                    currColumn.add(value);
                }
                else{
                    output.add(currColumn);
                    currentColIndex = column;
                    currColumn = new ArrayList();
                    currColumn.add(value);
                }
            }

            output.add(currColumn);

            return output;

        }

        private void DFS(TreeNode node , int row , int column){
            if(node == null) return;

            nodeList.add(new Triplet( row , column , node.val));

            DFS(node.left , row + 1 , column - 1);
            DFS(node.right , row + 1 , column + 1);
        }
    }



    class Triplet implements Comparable<Triplet>{
        int row;
        int column;
        int value;
        public Triplet(int row , int column , int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }

        @Override
        public int compareTo(Triplet triplet){
            if( this.column != triplet.column){
                return this.column - triplet.column;
            }
            if( this.row != triplet.row){
                return this.row - triplet.row;
            }

            return this.value - triplet.value;
        }
    }
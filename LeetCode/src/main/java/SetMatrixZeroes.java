import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    col.add(j);
                }

            }
        }

        /*int r;
        Iterator<Integer> itr = rows.iterator();
        while(itr.hasNext()){
            r=itr.next();
            for(int j=0;j<matrix[0].length;j++){
                matrix[r][j]=0;
            }
        }
        int c;
        itr = col.iterator();
        while(itr.hasNext()){
            c=itr.next();
            for(int i=0;i<matrix.length;i++){
                matrix[i][c]=0;
            }
        }
*/
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows.contains(i) || col.contains(j))
                    matrix[i][j]=0;
            }
        }

    }
}

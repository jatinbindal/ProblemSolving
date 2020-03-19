public class WordSearch {
    public static boolean  exist(char[][] board, String word) {
        int r = board.length, c = board[0].length;
        boolean flag[][];
        for(int i=0 ;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]==word.charAt(0)){
                    flag = new boolean[r][c];
                    flag[i][j]= true;
                    if(search(board,word,i,j,1,flag)) return true;
                }
            }
        }
        return false;


    }

    public static boolean search(char[][] board, String word, int row,int col, int ind, boolean[][] flag){
        if(ind==word.length()) return true;
        if(ind==word.length()-1){
            if(checkCell(board,word.charAt(ind),row-1,col,flag)) return true;
            if(checkCell(board,word.charAt(ind),row,col-1,flag)) return true;
            if(checkCell(board,word.charAt(ind),row+1,col,flag)) return true;
            if(checkCell(board,word.charAt(ind),row,col+1,flag)) return true;
            return false;

        }

        if(checkCell(board,word.charAt(ind),row-1,col,flag)){
            flag[row-1][col] = true;
            if(search(board,word,row-1,col,ind+1,flag)) return true;
            flag[row-1][col] = false;

        }
        if(checkCell(board,word.charAt(ind),row+1,col,flag)){
            flag[row+1][col] = true;
            if(search(board,word,row+1,col,ind+1,flag)) return true;
            flag[row+1][col] = false;

        }
        if(checkCell(board,word.charAt(ind),row,col-1,flag)){
            flag[row][col-1] = true;
            if(search(board,word,row,col-1,ind+1,flag)) return true;
            flag[row][col-1] = false;

        }
        if(checkCell(board,word.charAt(ind),row,col+1,flag)){
            flag[row][col+1] = true;
            if(search(board,word,row,col+1,ind+1,flag)) return true;
            flag[row][col+1] = false;

        }
        return false;

    }

    public static boolean checkCell(char[][] board, char c, int i,int j, boolean[][] flag){
        if(i<0 || i>= flag.length) return false;
        if(j<0 || j>= flag[0].length) return false;
        if(flag[i][j]==true) return false;
        if(board[i][j]==c) return true;
        return false;
    }
}

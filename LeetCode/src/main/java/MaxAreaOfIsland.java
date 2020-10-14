public class MaxAreaOfIsland {

        int max = 0;
        public int maxAreaOfIsland(int[][] grid) {
            int r = grid.length;
            int c  = grid[0].length;
            for(int i = 0 ; i  < r ; i++){
                for(int j = 0 ; j < c ; j++){
                    max = Math.max(max,dfs(i,j,grid,r,c));
                }
            }
            return max;
        }

        public int dfs(int x , int y,int[][] grid, int r , int c){

            if(x < 0 || x>= r || y<0 || y>=c || grid[x][y]!=1)
                return 0;
            grid[x][y] = 0;
            int up = dfs(x-1,y,grid,r,c);
            int down = dfs(x+1,y,grid,r,c);
            int left = dfs(x,y-1,grid,r,c);
            int right = dfs(x,y+1,grid,r,c);

            return
                    1+up+down+left+right;
        }
    }

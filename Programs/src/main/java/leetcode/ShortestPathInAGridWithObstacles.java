package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
//BFS
//flag matrix store the count of jumps left when it was last visited
public class ShortestPathInAGridWithObstacles {

        public int shortestPath(int[][] grid, int k) {

            int r = grid.length , c = grid[0].length;
            if(grid[0][0] == 1 || grid[r-1][c-1] == 1) return -1;
            if(r ==1 && c==1) return 0;
            int[][] visited = new int[r][c];
            for(int[] row : visited) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
            visited[0][0] = k;
            Deque<Cordinate> q = new LinkedList<>();
            q.add(new Cordinate(0,0,k));
            int distance = 0;
            int[] dir = new int[]{-1,0,1,0};
            while(!q.isEmpty()){
                //System.out.println(q);
                int size = q.size();
                distance++;
                while(size-- >0){

                    Cordinate pos = q.poll();
                    int x = pos.x , y = pos.y , jump = pos.jump;
                    for(int d  = 0 ; d < 4 ; d++){
                        int xdir = dir[d];
                        int ydir = dir[(d+1)%4];
                        int newX = x+xdir;
                        int newY = y+ydir;
                        if(newX == r-1 && newY == c-1) return distance;
                        if(newX < 0 || newX >= r || newY < 0 || newY >= c || (grid[newX][newY] == 1 && jump == 0 ))
                            continue;
                        if(visited[newX][newY] < jump){
                            int newJump = grid[newX][newY] == 1 ? jump-1 : jump;
                            visited[newX][newY] = newJump;
                            q.add(new Cordinate(newX,newY,newJump));
                        }

                    }

                }
            }
            return -1;

        }
    }

    class Cordinate{
        int x , y , jump;

        public Cordinate(int i , int j , int k){
            x = i;
            y = j;
            jump = k;

        }

    }




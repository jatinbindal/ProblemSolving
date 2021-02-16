package leetcode;

import java.util.PriorityQueue;

class TrapRainWater2D {
    int res = 0;
    int count = 0;
    boolean[][] visited;

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = (m == 0 ? 0 : heightMap[0].length);
        visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {i, 0, heightMap[i][0]});
            pq.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
            count+=2;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[] {0, j, heightMap[0][j]});
            pq.offer(new int[] {m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = visited[m - 1][j] = true;
            count+=2;
        }

        while (!pq.isEmpty() && count<n*m) {

            int[] cell = pq.poll();
            int row = cell[0], col = cell[1], curr = cell[2];
            fill(row-1,col,curr,heightMap,pq);
            fill(row+1,col,curr,heightMap,pq);
            fill(row,col-1,curr,heightMap,pq);
            fill(row,col+1,curr,heightMap,pq);
        }
        return res;
    }
    public void fill(int row, int col , int min, int[][] map,PriorityQueue<int[]> pq){
        if(row < 0 || col < 0 || row >= map.length || col >= map[0].length || visited[row][col])
            return;
        int curr = map[row][col];
        if(curr>=min){
            visited[row][col] = true;
            pq.offer(new int[]{row, col , curr});
            count++;
        }
        else{
            visited[row][col] = true;
            count++;
            System.out.println("here");
            res+=min - curr;
            fill(row-1,col,min,map,pq);
            fill(row+1,col,min,map,pq);
            fill(row,col-1,min,map,pq);
            fill(row,col+1,min,map,pq);
        }
    }
}
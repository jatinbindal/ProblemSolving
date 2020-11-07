import java.util.Arrays;

public class LetterTilePossibilities {
   //backtracking general
        int count=0;
        public int numTilePossibilities(String tiles) {

            int n=tiles.length();
            char[] chars = tiles.toCharArray();
            Arrays.sort(chars);
            boolean[] visited = new boolean[n];
            backtrack(chars,visited);
            return count;
        }



        public void backtrack(char[] tiles,boolean visited[])
        {

            for(int i=0;i<tiles.length;i++)
            {
                if(visited[i] || i>0 && tiles[i]==tiles[i-1] && visited[i-1]==false)
                    continue;
                visited[i]=true;
                count++;
                backtrack(tiles,visited);
                visited[i]=false;
            }
        }
    }



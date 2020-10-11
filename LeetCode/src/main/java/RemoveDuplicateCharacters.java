import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateCharacters {

        public String smallestSubsequence(String s) {


            boolean[] visited = new boolean[26];
            int[] highest = new int[26];
            for(int i = 0 ; i  < s.length() ; i++){
                char c = s.charAt(i);
                highest[c-'a']=i;
            }

            Deque<Character> stack = new ArrayDeque<>();
            for(int i = 0 ; i  < s.length()  ; i++){
                char c = s.charAt(i);
                if(visited[c-'a']) continue;
                while(!stack.isEmpty() && c<stack.peekLast()  && highest[stack.peekLast()-'a']>i){
                    visited[stack.pollLast()-'a'] = false;
                }
                stack.offer(c);
                visited[c-'a'] = true;
            }


            StringBuilder res = new StringBuilder();
            while(!stack.isEmpty()){
                res.append(stack.poll());
            }
            return res.toString();

        }
    }

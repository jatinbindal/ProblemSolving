import java.util.*;


//Bidirectional BFS
//transform 1 word to another using only given words
class WordLadder {
    Set<String> dict ;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue2 = new LinkedList<>();
        queue2.add(endWord);
        Set<String> visited2 = new HashSet<>();
        visited2.add(endWord);

        int levelVisit = 1 ;

        while (!queue.isEmpty() && !queue2.isEmpty()) {

            //Process one node from the smaller queue instead of both
            if(queue2.size() < queue.size()){
                Queue<String> temp = queue;
                queue = queue2;
                queue2 = temp;
                Set<String> tempSet = visited;
                visited = visited2;
                visited2 = tempSet;
            }

            int ans;
            ans = visitOneNode(queue,visited,visited2,levelVisit);
            levelVisit++;
            if(ans>-1) return ans;
            //ans = visitOneNode(queue2,visited2,visited,levelVisit);
            //if(ans > -1) return ans;
            //levelVisit++;
        }
        return 0;
    }

    public int visitOneNode(Queue<String> queue , Set<String> visited, Set<String> visited2, int levelVisit){
        int size = queue.size();
        for (int q=0; q < size; q++) {
            char[] cur = queue.poll().toCharArray();
            for (int i=0; i < cur.length; i++) {
                char tmp = cur[i];
                for (char chr='a'; chr <= 'z'; chr++) {
                    cur[i] = chr;
                    String dest = new String(cur);
                    if(visited2.contains(dest)){
                        return levelVisit+1;
                    }
                    if (!visited.contains(dest) && dict.contains(dest)) {
                        visited.add(dest);
                        queue.add(dest);
                    }
                }
                cur[i] = tmp;
            }
        }
        return -1;
    }
}
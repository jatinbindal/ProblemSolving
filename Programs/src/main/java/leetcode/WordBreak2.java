package leetcode;

import java.util.ArrayList;
import java.util.List;

class WordBreak2 {
    Trie rootTrie = new Trie();
    List<String> res  = new ArrayList();
    boolean[][] memo;
    public List<String> wordBreak(String s, List<String> wordDict) {

        this.memo = new boolean[s.length()][s.length()];
        for(String word : wordDict)
            rootTrie.addWord(word);
        List<Integer> space = new ArrayList<>();
        calculate(rootTrie,0,s,0,space);
        return res;

    }

    public boolean calculate(Trie trie, int startInd, String s, int ind, List<Integer> space){

        if(ind == s.length()){
            if(trie.s!=null){
                this.res.add(createResultString(s,space));
                return false;
            }
            return true;
        }
        if(memo[startInd][ind])
            return true;

        Trie temp = trie.children[s.charAt(ind) - 'a'];
        if(temp==null){
            memo[startInd][ind] = true;
            return true;
        }
        else{
            boolean cantGoFurther = calculate(temp,startInd,s,ind+1,space);
            if(temp.s!=null){
                space.add(ind+1);
                boolean cantGoFurther2 = calculate(rootTrie,ind+1,s,ind+1,space);
                space.remove(space.size()-1);
                cantGoFurther = cantGoFurther && cantGoFurther2;
            }
            memo[startInd][ind] = cantGoFurther;
            return cantGoFurther;
        }

    }

    public String createResultString(String s, List<Integer> space){
        StringBuilder sb = new StringBuilder(s);
        //System.out.println("Space Array"  + space.toString());
        for(int i = 0 ; i < space.size(); i++)
            sb.insert(i+space.get(i), ' ');

        return sb.toString();

    }
}

class Trie{

    Trie[] children = new Trie[26];
    String s = null;


    public void addWord(String word){
        Trie curr = this;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new Trie();
            curr = curr.children[c-'a'];
        }
        curr.s = word;
        //System.out.println(curr.s);
    }

}
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {

        public List<String> letterCasePermutation(String S) {

            List<String> results = new ArrayList<>();
            char[] s = S.toCharArray();
            backtrack(s,0,results);
            return results;

        }

        public void backtrack(char[] s, int ind, List<String> results){
            if(ind == s.length){
                results.add(new String(s));
                return;
            }

            backtrack(s,ind+1,results);
            if(s[ind]>='0' && s[ind]<='9')
                return;

            s[ind] = Character.isLowerCase(s[ind]) ? Character.toUpperCase(s[ind]) : Character.toLowerCase(s[ind]);
            backtrack(s,ind+1,results);

        }

    }




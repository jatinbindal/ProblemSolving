import java.util.ArrayList;
import java.util.List;

// general approach to backtracking

public class PalindromePartitioning {
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            backtrack(s, res, new ArrayList<>(), 0);
            return res;
        }

        public void backtrack(String s, List<List<String>> res, List<String> curr, int ind) {
            if (ind == s.length()) {
                res.add(new ArrayList<>(curr));
                return;
            }
            for (int i = ind; i < s.length(); i++) {
                if (isPalindrome(s, ind, i)) {
                    curr.add(s.substring(ind, i + 1));
                    backtrack(s, res, curr, i + 1);
                    curr.remove(curr.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
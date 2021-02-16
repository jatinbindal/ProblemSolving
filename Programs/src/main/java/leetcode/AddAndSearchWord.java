package leetcode;

//leetcode.Trie
//Dictionary
//with . characters
    public class AddAndSearchWord {

        class WordDictionary {

            /**
             * Initialize your data structure here.
             */

            WordDictionary[] child;
            boolean end;

            public WordDictionary() {
                child = new WordDictionary[26];

            }

            /**
             * Adds a word into the data structure.
             */
            public void addWord(String word) {
                WordDictionary p = this;
                for (int i = 0; i < word.length(); i++) {

                    char c = word.charAt(i);
                    if (p.child[c - 'a'] == null) p.child[c - 'a'] = new WordDictionary();
                    p = p.child[c - 'a'];
                }

                p.end = true;
            }


            /**
             * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
             */
            public boolean search(String word) {

                return match(word, 0, this);
            }

            public boolean match(String word, int ind, WordDictionary node) {
                if (ind == word.length()) return node.end;
                char c = word.charAt(ind);
                if (c != '.') {
                    return node.child[c - 'a'] != null && match(word, ind + 1, node.child[c - 'a']);
                } else {
                    for (int i = 0; i < 26; i++) {
                        if (node.child[i] != null) {
                            boolean val = match(word, ind + 1, node.child[i]);
                            if (val) return true;
                        }
                    }
                }

                return false;
            }
        }
    }
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

import java.util.*;

/**
 * Trie + DFS
 * 2023/09/16
 */

class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String s : products) {
            trie.insert(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> currAns = trie.findWordsStartWith(searchWord.substring(0, i + 1));
            ans.add(currAns);
        }

        return ans;
    }

    class Trie {
        class TrieNode {
            boolean isEnd;
            String word;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    p.children[pos] = new TrieNode();
                }
                sb.append(word.charAt(i));
                p = p.children[pos];
            }
            p.isEnd = true;
            p.word = sb.toString();
        }

        public List<String> findWordsStartWith(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int pos = prefix.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    return ans;
                }
                p = p.children[pos];
            }
            dfs(p, ans);
            return ans;
        }

        private void dfs(TrieNode p, List<String> ans) {
            if (p.isEnd) {
                ans.add(p.word);
            }
            if (ans.size() == 3) {
                return;
            }

            for (TrieNode t : p.children) {
                if (t != null) {
                    dfs(t, ans);
                }
                if (ans.size() == 3) {
                    return;
                }
            }
        }
    }
}
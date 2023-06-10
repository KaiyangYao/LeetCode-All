/*
 * Trie
 * 
 * Time:
 * addWord: O(L)  L = 字符串的长度
 * searchL O(C * L)  C = 26
 * 
 * Space:
 * O(n * L)  n = 插入字符串数量
 * 
 * 2023/02/07
 */
class Solution211 {
    class WordDictionary {
        class Node {
            boolean isWord = false;
            Node[] children = new Node[26]; 
        }
    
        Node root;
        public WordDictionary() {
            root = new Node();
        }
        
        public void addWord(String word) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    p.children[pos] = new Node();
                }
                p = p.children[pos];
            }
            p.isWord = true;
        }
        
        public boolean search(String word) {
            Node p = root;
            return dfs(p, word, 0);
        }
    
        private boolean dfs(Node node, String word, int index) {
            if (index == word.length()) {
                return node.isWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null && dfs(node.children[i], word, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
                return dfs(node, word, index + 1);
            }
        }
    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
}
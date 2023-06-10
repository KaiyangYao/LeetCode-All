/*
 * Trie
 * 
 * O(len(input)) time
 * O(nk) space  n = 结点数量，k = 字符集大小
 * 
 * Implement Trie 2: #1804
 * 
 * 2023/02/07
 */
class Solution208 {
    class Trie {
        class TrieNode {
            boolean isEnd;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    p.children[pos] = new TrieNode();
                }
                p = p.children[pos];
            }
            p.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    return false;
                }
                p = p.children[pos];
            }
            return p.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int pos = prefix.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    return false;
                }
                p = p.children[pos];
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
/*
 * Trie
 * 
 * O(len(input)) time
 * O(nk) space  n = 结点数量，k = 字符集大小
 * 
 * Implement Trie 1: #208
 * 
 * 2023/02/07
 */
class Solution1804 {
    class Trie {
        class TrieNode {
            int count;
            int endCount;
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
                p.count++;
            }
            p.endCount++;
        }
        
        public int countWordsEqualTo(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    return 0;
                }
                p = p.children[pos];
            }
            return p.endCount;
        }
        
        public int countWordsStartingWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                int pos = prefix.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    return 0;
                }
                p = p.children[pos];
            }
            return p.count;
        }
    
        public void erase(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (p.children[pos] == null) {
                    return;
                }
                p = p.children[pos];
                p.count--;
            }
            p.endCount--;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * int param_2 = obj.countWordsEqualTo(word);
     * int param_3 = obj.countWordsStartingWith(prefix);
     * obj.erase(word);
     */
}
import java.util.*;

/*
 * Method 1:
 * DFS recursion
 * 
 * Method 2:
 * DFS w/ Trie
 * 
 * K = len(words), L = avg length of each word
 * O(m*n*3^l) time
 * O(k * l) space
 * 
 * 2022/11/05, 2023/02/07
 */
class Solution212_01 {
    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
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
        return root;
    }

    int[][] visited;
    int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        visited = new int[m][n];
        Set<String> result = new HashSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                StringBuilder sb = new StringBuilder();
                dfs(board, r, c, root, sb, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, StringBuilder sb, Set<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] == 1) {
            return;
        }

        if (node.children[board[r][c] - 'a'] == null) {
            return;
        }

        visited[r][c] = 1;
        sb.append(board[r][c]);

        if (node.children[board[r][c] - 'a'].isEnd) {
            result.add(sb.toString());
        }

        for (int i = 0; i < 4; i++) {
            dfs(board, r + directions[i][0], c + directions[i][1], node.children[board[r][c] - 'a'], sb, result);
        }

        visited[r][c] = 0;
        sb.deleteCharAt(sb.length() - 1);
    }
}


/*
 * DFS recursion
 * 
 * 2022/11/05
 */
class Solution212_02 {
    Set<String> set = new HashSet<>();
    Set<Character> startLetter = new HashSet<>();
    List<String> answer = new ArrayList<>();
    int[][] directions = new int[][] { {-1, 0, 1, 0}, {0, 1, 0, -1} };
    char[][] board;
    int[][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        int numR = board.length;
        int numC = board[0].length;
        visited = new int[numR][numC];
        
        for (String word: words) {
            startLetter.add(word.charAt(0));
            set.add(word);
        }
        
        for (int r = 0; r < numR; r++) {
            for (int c = 0; c < numC; c++) {
                StringBuilder sb = new StringBuilder();
                if (startLetter.contains(board[r][c])) {
                    dfs(sb, r, c);
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(StringBuilder sb, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] == 1) {
            return;
        }
        String currWord = sb.append(board[r][c]).toString();
        if (currWord.length() > 10) {
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (set.contains(currWord)) {
            answer.add(currWord);
            set.remove(currWord);
        }

        visited[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            dfs(sb, r + directions[0][i], c + directions[1][i]);
        }

        visited[r][c] = 0;
        sb.deleteCharAt(sb.length() - 1);
    }
}
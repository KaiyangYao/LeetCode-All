import java.util.*;

/*
 * o(n) time | O(1) space
 * 
 * 2022/11/05
 */
class Solution212 {
    Set<String> set = new HashSet<>();
    List<String> answer = new ArrayList<>();
    int[][] directions = new int[][] { {-1,0}, {1,0}, {0,-1}, {0,1} };
    char[][] board;
    int[][] visited;
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        int numR = board.length;
        int numC = board[0].length;
        visited = new int[numR][numC];
        
        for (String word: words) {
            set.add(word);
        }
        
        for (int r = 0; r < numR; r++) {
            for (int c = 0; c < numC; c++) {
                StringBuilder sb = new StringBuilder();
                dfs(sb, r, c);
            }
        }
        
        return answer;
    }
    
    private void dfs(StringBuilder sb, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        if (visited[r][c] == 1) return;
        
        sb.append(board[r][c]);
        visited[r][c] = 1;
        String currWord = sb.toString();
        if (currWord.length() > 10) {
            visited[r][c] = 0;
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (set.contains(currWord)) {
            answer.add(currWord);
            set.remove(currWord);
        }
        
        dfs(sb, r-1, c);
        dfs(sb, r+1, c);
        dfs(sb, r, c-1);
        dfs(sb, r, c+1);
        
        visited[r][c] = 0;
        sb.deleteCharAt(sb.length() - 1);
    }
}
import java.util.*;

/**
 * dp + backtrack
 * 2023/11/02
 */
class Solution131 {
    boolean[][] p;
    List<List<String>> result;

    public List<List<String>> partition(String s) {
        int n = s.length();
        p = new boolean[n][n];
        result = new ArrayList<>();

        for (boolean[] arr : p) {
            Arrays.fill(arr, true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                p[i][j] = p[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        dfs(s, 0, new ArrayList<>());
        return result;
    }

    private void dfs(String s, int start, List<String> currList) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (p[start][end]) {
                currList.add(s.substring(start, end + 1));
                dfs(s, end + 1, currList);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
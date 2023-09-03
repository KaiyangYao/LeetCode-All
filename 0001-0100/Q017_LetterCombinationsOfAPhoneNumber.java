import java.util.*;

/**
 * 2023/09/02
 */

/**
 * O(n* 4^n) time
 * O(n) space
 */
class Solution017 {
    List<String> result;
    String[] numbers = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        dfs(0, digits, "");
        return result;
    }

    private void dfs(int curr, String digits, String s) {
        if (curr == digits.length()) {
            result.add(s);
            return;
        }
        String currString = numbers[digits.charAt(curr) - '0' - 2];
        for (int i = 0; i < currString.length(); i++) {
            dfs(curr + 1, digits, s + currString.charAt(i));
        }
    }
}
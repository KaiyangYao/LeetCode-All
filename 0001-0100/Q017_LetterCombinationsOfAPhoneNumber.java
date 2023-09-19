import java.util.*;

/**
 * 2023/09/02
 */

/**
 * O(4^n) time
 * O(n) space
 */

 /**
  * 用StringBuilder 需要 回溯 remove
  */
 class Solution017_01 {
    List<String> result;
    String[] numbers;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        numbers = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (digits.length() == 0) return result;
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, sb);
        return result;
    }

    private void dfs(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        String options = numbers[digits.charAt(index) - '2'];
        for (int i = 0; i < options.length(); i++) {
            sb.append(options.charAt(i));
            dfs(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/**
 * String 每次都建一个新的，所以不需要回溯 !!
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
import java.util.*;

/**
 * Backtrack
 * 2023/10/25
 */

/**
 * way less than O(2^n) time
 * O(n) space
 */
class Solution022 {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder sb, int left, int right, int max) {
        if (left == max && right == max) {
            result.add(sb.toString());
        }

        if (left < max) {
            sb.append("(");
            backtrack(sb, left + 1, right, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            backtrack(sb, left, right + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
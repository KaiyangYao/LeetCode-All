import java.util.*;

/**
 * Backtrack
 * 2023/11/02
 */

/**
 * 时间复杂度：O(n × 2^n) 其中 n 表示字符串的长度。递归深度最多为 n，所有可能的递归子状态最多为 2^n 个，每次个子状态的搜索时间为
 * O(n)
 * 空间复杂度：O(n × 2^n) 递归深度最多为 n，所有可能的递归子状态最多为 2^n 个
 */
class Solution784 {
    List<String> result;

    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        dfs(s.toCharArray(), 0);
        return result;
    }

    private void dfs(char[] arr, int index) {
        while (index < arr.length && Character.isDigit(arr[index])) {
            index++;
        }
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }

        arr[index] = String.valueOf(arr[index]).toLowerCase().charAt(0);
        dfs(arr, index + 1);
        arr[index] = String.valueOf(arr[index]).toUpperCase().charAt(0);
        dfs(arr, index + 1);
    }
}
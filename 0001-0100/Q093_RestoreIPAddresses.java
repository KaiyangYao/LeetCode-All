import java.util.*;

/**
 * Backtrack
 * 2023/11/02
 */
class Solution093 {
    List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        dfs(s, 0, new ArrayList<String>());
        return result;
    }

    private void dfs(String s, int start, List<String> currList) {
        if (start == s.length()) {
            if (currList.size() == 4) {
                result.add(String.join(".", currList));
                return;
            }
        }

        for (int end = start; end < s.length() && end <= start + 2; end++) {
            if (s.charAt(start) == '0' && end != start) {
                return;
            }

            int v = Integer.parseInt(s.substring(start, end + 1));
            if (v >= 0 && v <= 255) {
                currList.add(s.substring(start, end + 1));
                dfs(s, end + 1, currList);
                currList.remove(currList.size() - 1);
            }
           
        } 
    }
}
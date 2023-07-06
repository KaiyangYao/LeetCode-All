import java.util.*;

/**
 * Sliding Window
 * 
 * 2023/07/05
 */
class Solution030 {
    public List<Integer> findSubstring(String s, String[] words) {
        int m = s.length();
        int n = words.length;
        int len = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String str : words) {
            wordMap.put(str, wordMap.getOrDefault(str, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        out: for (int i = 0; i + n * len <= m; i++) {
            Map<String, Integer> countMap = new HashMap<>();
            String sub = s.substring(i, i + n * len);
            for (int j = 0; j < sub.length(); j += len) {
                String curr = sub.substring(j, j + len);
                if (!wordMap.containsKey(curr)) continue out;
                countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
            }
            if (wordMap.equals(countMap)) {
                result.add(i);
            }
        }
        return result;
    }
}
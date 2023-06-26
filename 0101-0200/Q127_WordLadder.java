import java.util.*;

/**
 * 双向BFS
 * 
 * 2023/06/24
 * 
 * 时间复杂度：令 wordList 长度为 n，beginWord 字符串长度为 m。由于所有的搜索结果必须都在 wordList 出现过，因此算上起点最多有 n+1 节点，
 * 最坏情况下，所有节点都联通，搜索完整张图复杂度为 O(n^2). 从 beginWord 出发进行字符替换，替换时进行逐字符检查，复杂度为 O(m)。
 * 整体复杂度为 O(m * n^2)
 * 
 * 空间复杂度相同
 */
class Solution127 {
    Set<String> set = new HashSet<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String w: wordList) {
            set.add(w);
        }
        if (!set.contains(endWord)) return 0;
        int ans = bfs(beginWord, endWord);
        return ans == -1 ? 0 : ans;
    }

    private int bfs(String beginWord, String endWord) {
        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();
        q1.offer(beginWord);
        q2.offer(endWord);
        m1.put(beginWord, 0);
        m2.put(endWord, 0);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int count = -1;
            if (q1.size() < q2.size()) {
                count = update(q1, q2, m1, m2);
            } else {
                count = update(q2, q1, m2, m1);
            }
            if (count != -1) return count;
        }
        return -1;
    }

    private int update(Queue<String> curr, Queue<String> other, Map<String, Integer> currMap, Map<String, Integer> otherMap) {
        int size = curr.size();
        for (int c = 0; c < size; c++) {
            String currWord = curr.poll();
            for (int i = 0; i < currWord.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    StringBuffer sb = new StringBuffer(currWord);
                    sb.setCharAt(i, (char)('a' + j));
                    String nextWord = sb.toString();
                    if (currMap.containsKey(nextWord)) continue;
                    if (otherMap.containsKey(nextWord)) {
                        return currMap.get(currWord) + otherMap.get(nextWord) + 2;
                    }
                    if (set.contains(nextWord)) {
                        curr.offer(nextWord);
                        currMap.put(nextWord, currMap.get(currWord) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
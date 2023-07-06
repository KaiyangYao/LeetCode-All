import java.util.*;

/**
 * 建图 + Topological Sort + 字符串字典序排列
 * 
 * 2023/06/27
 */

class Solution269 {
    Map<Character, List<Character>> edges = new HashMap<>();
    Map<Character, Integer> inDegree = new HashMap<>();
    boolean isValid = true;

    public String alienOrder(String[] words) {
        // Contrust Map
        for (String word: words) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char c = word.charAt(i);
                edges.putIfAbsent(c, new ArrayList<Character>());
            }
        }

        // Add Edge
        for (int i = 1; i < words.length; i++) {
            addEdge(words[i-1], words[i]);
            if (!isValid) {
                return "";
            }
        }

        // Top Sort
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();
        for (char c: edges.keySet()) {
            if (!inDegree.containsKey(c)) {
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char next: edges.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    q.offer(next);
                }
            }
        }

        return sb.length() == edges.size() ? sb.toString() : "";
    }

    private void addEdge(String w1, String w2) {
        int l1 = w1.length();
        int l2 = w2.length();
        for (int i = 0; i < l1 && i < l2; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (c1 != c2) {
                edges.get(c1).add(c2);
                inDegree.put(c2, inDegree.getOrDefault(c2, 0) + 1);
                return;
            }
        }

        if (l1 > l2) {
            isValid = false;
            return;
        }
    }
}
import java.util.*;

/**
 * BFS
 * 
 * 2023/06/22
 * 
 * O(4*n*m) time | O(n*m) space
 * n = 基因序列长度，m = bank长度
 */
class Solution433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] charList = new char[] {'A', 'C', 'G', 'T'};

        for (String s: bank) {
            set.add(s);
        }

        if (startGene.equals(endGene)) {
            return 0;
        }

        if (!set.contains(endGene)) {
            return -1;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(startGene);
        visited.add(startGene);
        int step = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                for (int pos = 0; pos < 8; pos++) {
                    for (int mut = 0; mut < 4; mut++) {
                        if (curr.charAt(pos) == charList[mut]) continue;
                        StringBuffer sb = new StringBuffer(curr);
                        sb.setCharAt(pos, charList[mut]);
                        String next = sb.toString();
                        if (!visited.contains(next) && set.contains(next)) {
                            if (next.equals(endGene)) {
                                return step;
                            }
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
            step++;
        }

        return -1;
    }
}
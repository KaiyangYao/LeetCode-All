import java.util.*;

/**
 * 2023/01/13
 * Hashmap + 双指针
 */

/**
 * Solution1 (不好写)
 * O(n) time | O(1) space
 */
class Solution2182_01 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int m = 0;
        for (int r = 25, l = 24; r >= 0 && l >= 0;) {
            if (cnt[r] == 0) {
                m = 0;
                r--;
            } else if (m < repeatLimit) {
                cnt[r]--;
                sb.append((char) ('a' + r));
                m++;
            } else if (l >= r || cnt[l] == 0) {
                l--;
            } else {
                cnt[l]--;
                sb.append((char) ('a' + l));
                m = 0;
            }
        }

        return sb.toString();
    }
}

/**
 * Solution2: Priority Queue (更好想)
 * O(n) time | O(n) space
 */
class Solution2182_02 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                pq.offer(new int[] {i, cnt[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            // 每次取出最大的
            int[] curr = pq.poll();
            for (int i = 0; i < repeatLimit && curr[1] > 0; i++) {
                sb.append((char) ('a' + curr[0]));
                curr[1]--;
            }
            
            // 如果超过了限制，就取出第二大的放入一个
            if (curr[1] > 0) {
                if (pq.isEmpty()) {
                    break;  // 没有第二大的了，退出
                }
                int[] prev = pq.poll();
                sb.append((char) ('a' + prev[0]));
                prev[1]--;
                if (prev[1] > 0) {
                    pq.offer(new int[] {prev[0], prev[1]});
                }
                pq.offer(new int[] {curr[0], curr[1]});
            }
         }

         return sb.toString();
    }
}
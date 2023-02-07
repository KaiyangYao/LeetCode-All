import java.util.*;

/*
 * Sliding Window
 * 
 * len(s) = m, len(p) = n, C = 26
 * O(n + Cm) = O(m) time
 * O(c) = O(1) space
 * 
 * 2023/02/04
 */
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c: p.toCharArray()) {
            c2[c - 'a']++;
        }

        for (int left = 0, right = 0; right < s.length(); right++) {
            c1[s.charAt(right) - 'a']++;
            if (right - left + 1 > p.length()) {
                c1[s.charAt(left) - 'a']--;
                left++;
            }
            if (check(c1, c2)) {
                ans.add(left);
            }
        }

        return ans;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
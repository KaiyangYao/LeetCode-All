import java.util.*;

/**
 * 2023/01/16
 * 前提条件: words里的词互不相同，仅包含小写字母，每个word的长度仅为2
 * 因此可以用自定义的hash公式: 100 * word[0] + word[1]
 */

/*
 * O(n) time | O(n) space
 */
class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (String word : words) {
            if (set.contains(word.charAt(1) * 100 + word.charAt(0))) {
                cnt++;
            }
            set.add(word.charAt(0) * 100 + word.charAt(1));
        }
        return cnt;
    }
}
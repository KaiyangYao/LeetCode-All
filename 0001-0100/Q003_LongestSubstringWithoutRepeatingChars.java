import java.util.*;

/*
 * Sliding window w/ Hashmap
 * 
 * O(n) time  [虽然有两层循环，但每个字符在哈希表中最多只会被插入和删除一次，复杂度为 O(n)]
 * O(n) space
 * 
 * 2023/02/03
 */
class Solution003_01 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while (map.get(curr) > 1) {
                char left = s.charAt(start);
                map.put(left, map.get(left) - 1);
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}

/**
 * Method 2: map记录每个char的index，这样下次遇到相同的肯定必须至少从 index+1 开始
 * 另外注意每次要 Math.max(start, index+1);
 */
class Solution003_02 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            if (map.containsKey(curr)) {
                start = Math.max(map.get(curr) + 1, start);
            }
            map.put(curr, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
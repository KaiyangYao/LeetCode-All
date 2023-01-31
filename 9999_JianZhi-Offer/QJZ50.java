import java.util.*;

/*
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 
 * O(n) time | O(1) space (only 26 letters, O(26) = O(1))
 * 
 * 2023/01/29
 */

class QJZ50 {
    // Method 1:
    // O(len(s)) + O(len(s)) time
    public char firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    // Method 2: 有序哈希表
    // O(len(s)) + O(26) time
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
           if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
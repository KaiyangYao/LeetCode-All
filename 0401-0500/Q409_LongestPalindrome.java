import java.util.*;

/*
 * Palindrome (only 1 char can be odd)
 * 
 * O(n) time | O(1) space  ( 由于 ASCII 字符数量为 128 ，哈希表 counter 最多使用 O(128)=O(1) 空间。)
 * 
 * 2022/11/08
 */
class Solution409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        boolean hasMiddle = false;
        int result = 0;
        
        for (char c: map.keySet()) {
            int count = map.get(c);
            if (count % 2 == 1) {
                hasMiddle = true;
            }
            result += count / 2 * 2;
        }
        
        if (hasMiddle) {
            result += 1;
        }
        
        return result;
    }
}
import java.util.*;

/*
 * O(n) time
 * 
 * 2022/11/03
 */
class Solution2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        boolean hasMiddle = false;
        int length = 0;
        
        for (String word: wordCount.keySet()) {
            int numAppeared = wordCount.get(word);
            if (word.charAt(0) == word.charAt(1)) {
                if (numAppeared % 2 == 1) {
                    hasMiddle = true;
                }
                length += numAppeared / 2 * 4;
            } else if (word.charAt(0) > word.charAt(1)) {
                StringBuilder sb = new StringBuilder(word);
                String reverse = sb.reverse().toString();
                if (wordCount.containsKey(reverse)) {
                    length += Math.min(numAppeared, wordCount.get(reverse)) * 4;
                }
            }
        }
        
        if (hasMiddle) {
            length += 2;
        }
        
        return length;
    }
}
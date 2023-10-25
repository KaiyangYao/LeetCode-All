import java.util.*;

/**
 * 2023/10/20
 */

/*
 * O(n klogk) time
 * O(nk) space
 */
class Solution049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String curr = new String(charArr);
            List<String> list = map.getOrDefault(curr, new ArrayList<>());
            list.add(str);
            map.put(curr, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }
}
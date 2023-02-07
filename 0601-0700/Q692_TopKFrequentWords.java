import java.util.*;

/*
 * Priority Queue / Comparator
 * 
 * O(n log(n)) time，可优化成 O(nlog(k)) time!
 * O(n) space
 * 
 * 2023/02/07
 */

 // 1. Priority Queue 做法
class Solution692_01 {
    public List<String> topKFrequent(String[] words, int k) {
        // O(n) for counting
        Map<String, Integer> map = new HashMap<>();
        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        // O(nlog(n))
        // 如果要变成 O(nlog(k))，把pq返过来，然后如果每次超了就poll()然后再offer()
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey());
        });

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        // O(k)
        // 如果要变成O(nlog(k))，最后要Collections.reverse(ans)
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().getKey());
        }
        return result;
    }
}

// 2. 纯Comparator做法
// O(n log(n)) time 
//  O(n) space
class Solution692_02 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String word: words) {
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }
        
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: cntMap.entrySet()) {
            result.add(entry.getKey());
        }
        
        Collections.sort(result, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cntMap.get(word1) == cntMap.get(word2) ? word1.compareTo(word2) : cntMap.get(word2) - cntMap.get(word1);
            }
        });
        
        return result.subList(0, k);
    }
}
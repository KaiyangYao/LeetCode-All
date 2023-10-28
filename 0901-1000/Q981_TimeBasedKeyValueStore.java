import java.util.*;

/**
 * Binary Search + Class
 * 2023/10/26
 */
class TimeMap {
    class Pair {
        String v;
        int t;

        public Pair(String v, int t) {
            this.v = v;
            this.t = t;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> curr = map.getOrDefault(key, new ArrayList<Pair>());
        curr.add(new Pair(value, timestamp));
        map.put(key, curr);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> curr = map.get(key);
        int left = 0, right = curr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (curr.get(mid).t == timestamp) {
                return curr.get(mid).v;
            } else if (curr.get(mid).t < timestamp) {
                left = mid + 1;
            } else if (curr.get(mid).t > timestamp) {
                right = mid - 1;
            }
        }
        return right >= 0 ? curr.get(right).v : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
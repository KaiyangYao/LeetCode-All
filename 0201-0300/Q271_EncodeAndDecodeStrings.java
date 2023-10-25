import java.util.*;

/**
 * O(n) time
 * O(n) space for encode, O(1) space for decode
 * 
 * 2023/10/24
 */

/**
 * Solution 1
 * 
 * Use a non-ASCII as an end point for each string
 */

/**
 * Solution 2
 * 
 * 构造: [# strings], [len of (len of each str)][len of 1st str][String] [len of 2nd str] [String]
 */
class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs.size());
        sb.append(",");
        for (int i = 0; i < strs.size(); i++) {
            sb.append(String.valueOf(strs.get(i).length()).length()); // length of # chars
        }
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        System.out.println(s);
        int p1 = 0;
        int count = s.charAt(p1++) - '0';
        while (s.charAt(p1) != ',') {
            count = count * 10 + (s.charAt(p1++) - '0');
        }
        p1++;
        int curr = p1 + count;

        for (int i = 0; i < count; i++) {
            int numLen = s.charAt(p1++) - '0';
            int len = Integer.valueOf(s.substring(curr, curr + numLen));
            curr += numLen;
            result.add(s.substring(curr, curr + len));
            curr += len;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
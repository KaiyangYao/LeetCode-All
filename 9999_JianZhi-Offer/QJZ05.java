/*
 * 剑指 Offer 05. 替换空格
 * 
 * O(n) time, O(n) space
 * 
 * 2023/01/27
 */
class QJZ05 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
/*
 * 
 * O(|target|) time | O(1) space
 * 
 * 2022/11/04
 * https://leetcode.cn/problems/reach-a-number/solutions/1947254/fen-lei-tao-lun-xiang-xi-zheng-ming-jian-sqj2/
 */
class Solution754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int num = 0;
        
        while (num < target || (num-target) % 2 == 1) {
            step++;
            num += step;
        }
        
        return step;
    }
}
import java.util.*;

/* 
 * O(n) time | O(1) space
 * 
 * 摩尔投票法 (Boyer–Moore majority vote algorithm)
 * 或叫抵消法
 * 
 * 基础题: #169
 * 
 * 2023/06/10
 */
class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0;
        int c1 = 0, c2 = 0;
        
        for (int num: nums) {
            if (c1 != 0 && a == num) {
                c1++;
            } else if (c2 != 0 && b == num) {
                c2++;
            } else if (c1 == 0) {
                a = num;
                c1++;
            } else if (c2 == 0) {
                b = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        // 重新查看这两个是不是都 > n/3
        c1 = 0;
        c2 = 0;
        for (int num: nums) {
            if (num == a) {
                c1++;
            } else if (num == b) {
                c2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (c1 > nums.length / 3) result.add(a);
        if (c2 > nums.length / 3) result.add(b);

        return result;
    }
}
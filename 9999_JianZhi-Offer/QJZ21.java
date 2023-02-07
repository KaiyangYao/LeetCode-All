/*
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 
 * Two Pointers
 * O(n) time | O(1) space
 * 
 * 2023/02/07
 */
class QJZ21 {
    public int[] exchange(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && nums[p1] % 2 == 1) {
                p1++;
            }
            while (p1 < p2 && nums[p2] % 2 == 0) {
                p2--;
            }
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
        }
        return nums;
    }
}
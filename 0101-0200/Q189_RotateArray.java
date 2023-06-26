/* 
 * O(n) time | O(1) space
 * 
 * 以 n = 7, k = 3 为例
 * 原始数组	1 2 3 4 5 6 7
 * 翻转所有元素	7 6 5 4 3 2 1
 * 分成两份 7 6 5   4 3 2 1
 * 分别翻转 5 6 7   1 2 3 4
 * 
 * 2023/06/10
 */
class Solution189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
import java.util.*;
/*
 * 剑指 Offer 45. 把数组排成最小的数
 * 
 * Quick Sort
 * 规律：如果拼接字符串 x + y > y + x, 则 x "大于" y
 * 反之 如果拼接字符串 x + y < y + x, 则 x "小于" y
 * 
 * O(log(n)) time | O(n) space
 * 
 * 2023/02/08
 */

// 1. Customize Comparator
class QJZ45_01 {
    public String minNumber(int[] nums) {
        String[] l = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            l[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(l, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (String s: l) {
            sb.append(s);
        }
        return sb.toString();
    }
}

// 2. Customize QuickSort
class QJZ45_02 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = left;
        int l = left + 1;
        int r = right;
        while (l <= r) {
            while (l <= r && (strs[l] + strs[pivot]).compareTo(strs[pivot] + strs[l]) <= 0) {
                l++;
            }
            while (l <= r && (strs[pivot] + strs[r]).compareTo(strs[r] + strs[pivot]) <= 0) {
                r--;
            }
            if (l <= r) {
                swap(strs, l, r);
            }
        }

        swap(strs, pivot, r);

        quickSort(strs, left, r - 1);
        quickSort(strs, r + 1, right);
    }

    private void swap(String[] strs, int l, int r) {
        String tmp = strs[l];
        strs[l] = strs[r];
        strs[r] = tmp;
    }
}
import java.util.*;

/*
 * 剑指 Offer 40. 最小的k个数
 * 
 * 1. Quick Sort 变形 (每次只用管一边)
 * O(n) time | O(1) space
 * 
 * 2. 用k堆维护
 * O(nlogk) time | O(k) space
 * 
 * 两种方法比较：
 * https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solutions/159761/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
 * 第一，算法需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度就上去了。
 * 第二，算法需要保存所有的数据。如果把数据看成输入流的话，使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k 个元素的最大堆。
 * 而快速选择的方法需要先保存下来所有的数据，再运行算法。当数据量非常大的时候，甚至内存都放不下的时候，就麻烦了。所以当数据量大的时候还是用基于堆的方法比较好。
 * 
 * 2023/02/12
 */

 // Quick Select
class QJZ40_01 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k >= arr.length) {
            return arr;
        }
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    private int[] quickSelect(int[] arr, int start, int end, int k) {
        int x = partition(arr, start, end);
        if (x == k) {
            return Arrays.copyOfRange(arr, 0, k);
        } else if (x < k) {
            return quickSelect(arr, x + 1, end, k);
        } else {
            return quickSelect(arr, start, x - 1, k);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = start;
        int l = start + 1;
        int r = end;
        while (l <= r) {
            while (l <= r && arr[l] <= arr[pivot]) {
                l++;
            }
            while (l <= r && arr[r] >= arr[pivot]) {
                r--;
            }
            if (l <= r) {
                swap(arr, l, r);
            }
        }
        swap(arr, pivot, r);
        return r;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}

// Heap
class QJZ40_02 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
    
        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < k || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > k) {
                heap.poll(); // 删除堆顶最大元素
            }
        }
    
        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }
        return res;
    }
}
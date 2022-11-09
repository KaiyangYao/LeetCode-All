import java.util.*;;

/*
 * HashMap
 * 
 * O(n) time | O(n) space
 * 
 * 2022/11/04
 */
class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                return new int[]{map.get(curr), i};
            }
            
            map.put(target - curr, i);
        }
        
        return new int[]{0};
    }
}
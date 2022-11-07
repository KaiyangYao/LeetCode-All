import java.util.*;
/*
 * O(numRows^2) time
 * O(1) space
 * 
 * 2022/11/06
 */
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> currRow = new ArrayList<>();
            for (int index = 0; index <= i; index++) {
                if (index == 0 || index == i) {
                    currRow.add(1);
                } else {
                    currRow.add( answer.get(i-1).get(index) + answer.get(i-1).get(index-1) );
                }
            }
            answer.add(currRow);
        }
        
        return answer;
    }
}